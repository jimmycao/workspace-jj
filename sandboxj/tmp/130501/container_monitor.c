/**
 * query container state.
 * container is input parameter, state/retval/diag_msg is output param
 * when succeed, state will always be set, and retval/diag_msg will be
 * set when container completed. And 0 will be returned
 * when failed, will return other value.

int query_container_state(
    allocated_container_t* container,
    container_state_t* state,
    int* retval,
    char** diag_msg);
===========================

typedef struct {
    hadoop_rpc_proxy_t  *orte_ras_yarn_am_proxy;
    opal_pointer_array_t hosts;            // list<node>
    opal_pointer_array_t host_containers;  // list<list<container>>
    allocate_resource_context_t res_context;
} yarn_globals_t;
ORTE_DECLSPEC extern yarn_globals_t yarn_globals;

typedef struct {
    container_state_t state;
    int container_id;
    int exit_status;
    char* diagnostics_msg;
} container_status_t;


// global arrays for data storage
opal_pointer_array_t *orte_job_data;
 */

static orte_proc_t* get_proc_in_container(uint16_t host_idx, uint16_t container_idx)
{
	orte_proc_t*  found_proc = NULL;
	orte_proc_t*  tmp_proc = NULL;
	uint16_t proc_idx;
	uint16_t con_idx_4_prc;

	char* hostname = opal_pointer_array_get_item(&yarn_globals.hosts, host_idx);
	/* here, orte_job_data is a global variable in runtime/orte_globals; 0th for daemon job, 1th is for process job */
	orte_job_t* jdata = (orte_job_t*)opal_pointer_array_get_item(orte_job_data, 1);
	for (proc_idx = 0; proc_idx < jdata->num_procs; proc_idx++) {
		tmp_proc = (orte_proc_t*)opal_pointer_array_get_item(jdata->procs, proc_idx);

		if (host_idx == 0) {
			con_idx_4_prc = tmp_proc->local_rank;
		} else {
			con_idx_4_prc = tmp_proc->local_proc + 1;
		}

		if ((0 == strcmp(tmp_proc->node->name, hostname)) && (container_idx == con_idx_4_prc)){
			found_proc = tmp_proc;
			break;
		}
	}

	return found_proc;
}


static void container_state_monitor_cb(int fd, short args, void *cbdata)
{
	uint16_t host_idx, c_idx, k;
	yarn_container_monitor_t *mon = (yarn_container_monitor_t *)cbdata;
	struct timeval tv = {1, 0};

	containers_status_array_t* completed_c_array = NULL;
	/* 1. get_completed_containers */
	if (NULL == (completed_c_array = get_completed_containers(yarn_globals.orte_ras_yarn_am_proxy))) {
		opal_output(0, "state::yarn::daemon_state_monitor_cb, get_completed_containers is null");
		goto NEXT_TURN;
	}

	/* 2.1 traverse each host */
	for (host_idx = 0; host_idx < yarn_globals.host_containers.size; host_idx++) {
		opal_pointer_array_t* host_containers = opal_pointer_array_get_item(&yarn_globals.host_containers, host_idx);
		if (NULL == host_containers)
			continue;
		/* 2.2 on each host, traverse each container */
		for (c_idx = 0; c_idx < host_containers->size; c_idx++) {
			allocated_container_t* container = opal_pointer_array_get_item(host_containers, c_idx);
			if (NULL == container)
				continue;
			/* 2.3 for each container, to check if it is in completed_c_array, so just traverse the completed_c_array */
			for (k = 0; k < completed_c_array->num_containers; k++) {
				container_status_t *c_status = completed_c_array->containers[k];
				if (c_status->container_id != container->container_id)
					continue;
				else {  /* this container IS IN completed_c_array */
					if (c_idx == 0) {  /* index == 0 means this container is for daemon */
						opal_output(0,
								"state::yarn::daemon_state_monitor_cb, errors occur to daemon's container on host = %s",
								container->host);
						/* force terminate */
						ORTE_TERMINATE(ORTE_ERROR_DEFAULT_EXIT_CODE);
					} else {  /* this container is for normal process */
						/* (a) to get which process in this container */
						orte_proc_t *found_proc = get_proc_in_container(host_idx, c_idx);
						if(NULL == found_proc) {
							break;
						}

						/* (b) if this process is already terminated, just skip over */
						if(found_proc->state >= ORTE_PROC_STATE_TERMINATED) {
							break;
						}

						/* (c) modify this process's state to ORTE_PROC_STATE_FAILED_TO_LAUNCH */
						if (c_status->exit_status == -1000 || c_status->exit_status == -100 || c_status->exit_status == -101) {
							found_proc->state = ORTE_PROC_STATE_FAILED_TO_LAUNCH;
							ORTE_ACTIVATE_PROC_STATE(&found_proc->name, ORTE_PROC_STATE_FAILED_TO_LAUNCH);
						}
					}
				}
			}
		}
	}

	return;

NEXT_TURN:
	opal_event_evtimer_set(orte_event_base, &mon->ev, container_state_monitor_cb, mon);
	opal_event_evtimer_add(&mon->ev, &tv);
}



//allocated_container_t* container = NULL;
//       if (0 == host_rank) {
//           // if we're in hnp node, simply use local_rank to get container for this proc
//           container = opal_pointer_array_get_item(containers, proc->local_rank);
//       } else {
//           // if we're in other nodes, we need consider will occupy first container
//           container = opal_pointer_array_get_item(containers, proc->local_rank + 1);
//       }
//
//       if (!container) {
//           opal_output(0, "plm:yarn, failed to find a container for proc:%d", proc->name.vpid);
//           jdata->state = ORTE_JOB_STATE_FAILED_TO_LAUNCH;
//           ORTE_ACTIVATE_JOB_STATE(jdata, ORTE_JOB_STATE_NOTIFY_COMPLETED);
//           return;
//       }

//for (idx = 0; idx < jdata->num_procs; idx++) {
//        /* get proc and app */
//        proc = (orte_proc_t*) opal_pointer_array_get_item(jdata->procs, idx);
//        app = (orte_app_context_t*) opal_pointer_array_get_item(jdata->apps,
//                proc->app_idx);
//
//        /* 1. call NM to launch containers one by one */
//        /* 1.1. set env and argv */
//        rc = setup_proc_env_and_argv(jdata, app, proc, &launch_context);
//        if (rc != 0) {
//            OPAL_OUTPUT_VERBOSE((0, orte_state_base_framework.framework_output,
//                            "plm:yarn: set proc_env_and_argv failed."));
//            ORTE_ERROR_LOG(rc);
//            jdata->state = ORTE_JOB_STATE_FAILED_TO_LAUNCH;
//            ORTE_ACTIVATE_JOB_STATE(jdata, ORTE_JOB_STATE_NOTIFY_COMPLETED);
//            return;
//        }
//
//        OPAL_OUTPUT_VERBOSE((5, orte_state_base_framework.framework_output,
//                        "plm:yarn: after setup env and argv for proc=%d.", idx));
//
//        /* 2. launch this process via YARN ContainerManager protocol */
//        /* 2.1. get a container for this process */
//        int host_rank = 0;
//        for (i = 1; i < yarn_globals.hosts.size; i++) {
//            char* host = opal_pointer_array_get_item(&yarn_globals.hosts, i);
//            if (!host) {
//                continue;
//            }
//            if (0 == strcmp(host, proc->node->name)) {
//                host_rank = i;
//                break;
//            }
//        }
//
//        // get containers in this host
//        opal_pointer_array_t* containers = opal_pointer_array_get_item(&yarn_globals.host_containers, host_rank);
//        if (!containers) {
//            opal_output(0, "plm:yarn container list of this host_rank:%d is NULL", host_rank);
//            jdata->state = ORTE_JOB_STATE_FAILED_TO_LAUNCH;
//            ORTE_ACTIVATE_JOB_STATE(jdata, ORTE_JOB_STATE_NOTIFY_COMPLETED);
//            return;
//        }
//        allocated_container_t* container = NULL;
//        if (0 == host_rank) {
//            // if we're in hnp node, simply use local_rank to get container for this proc
//            container = opal_pointer_array_get_item(containers, proc->local_rank);
//        } else {
//            // if we're in other nodes, we need consider will occupy first container
//            container = opal_pointer_array_get_item(containers, proc->local_rank + 1);
//        }
//
//        if (!container) {
//            opal_output(0, "plm:yarn, failed to find a container for proc:%d", proc->name.vpid);
//            jdata->state = ORTE_JOB_STATE_FAILED_TO_LAUNCH;
//            ORTE_ACTIVATE_JOB_STATE(jdata, ORTE_JOB_STATE_NOTIFY_COMPLETED);
//            return;
//        }
//        opal_output(5,
//                "plm:yarn get container for proc=%d, node=%s, container_host=%s, container_id=%d",
//                proc->name.vpid, proc->node->name, container->host,
//                container->container_id);

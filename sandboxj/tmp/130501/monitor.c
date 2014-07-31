typedef struct {
    opal_object_t super;
    opal_event_t ev;
    orte_job_t *job;
} yarn_daemon_monitor_t;
OBJ_CLASS_INSTANCE(yarn_daemon_monitor_t, opal_object_t, NULL, NULL);

/*
     * here we set a timer event to check daemons status
     */
    yarn_daemon_monitor_t *mon;
    struct timeval tv = {10, 0};
	mon = OBJ_NEW(yarn_daemon_monitor_t);
	mon->job = daemons;
	opal_event_evtimer_set(orte_event_base, &mon->ev, daemon_state_monitor_cb, mon);
	opal_event_evtimer_add(&mon->ev, &tv);

//typedef enum {
//    /** New container */
//    CONTAINER_NEW = 1,
//
//    /** Running container */
//    CONTAINER_RUNNING = 2,
//
//    /** Completed container */
//    CONTAINER_COMPLETE = 3
//} container_state_t;

///*
// * type for container status
// */
//typedef struct {
//    container_state_t state;
//    int container_id;
//    int exit_status;
//    char* diagnostics_msg;
//} container_status_t;
//
///*
// * completed containers
// */
//typedef struct {
//    container_status_t** containers;
//    int num_containers;
//} containers_status_array_t;
//
///* yarn's global variable */
//typedef struct {
//    hadoop_rpc_proxy_t  *orte_ras_yarn_am_proxy;
//    opal_pointer_array_t hosts;            // list<node>
//    opal_pointer_array_t host_containers;  // list<list<container>>
//    allocate_resource_context_t res_context;
//} yarn_globals_t;
//ORTE_DECLSPEC extern yarn_globals_t yarn_globals;

static void daemon_state_monitor_cb(int fd, short args, void *cbdata)
{
	int i, j;
	bool err_flag = false;
	yarn_daemon_monitor_t *caddy = (yarn_daemon_monitor_t *)cbdata;
	orte_job_t* daemons = caddy->job;

	containers_status_array_t* completed_c_array = NULL;
	container_status_t *c_status = NULL;

	if (NULL == (completed_c_array = get_completed_containers(yarn_globals.orte_ras_yarn_am_proxy))) {
		opal_output(0, "state::yarn::daemon_state_monitor_cb, get_completed_containers is null");
		return;
	}

	for (i = 0; i < yarn_globals.host_containers.size; i++) {
		opal_pointer_array_t* containers = opal_pointer_array_get_item(&yarn_globals.host_containers, i);
		if (NULL == containers)
			continue;
		allocated_container_t* container = opal_pointer_array_get_item(containers, 0); /* 0 is for the daemon proc */
		/* to check whether any deamon's 'container_id' is in 'completed_c_array',
		 * if found, which means errors occur to this daemon.
		 */
		for (j = 0; j < completed_c_array->num_containers; j++) {
			c_status = completed_c_array->containers[j];
			if (container->container_id == c_status->container_id) {
				opal_output(0, "state::yarn::daemon_state_monitor_cb, errors occur to daemon's container on host = %s", container->host);
				/* force terminate */
				ORTE_TERMINATE(ORTE_ERROR_DEFAULT_EXIT_CODE);
			}
		}
	}
}

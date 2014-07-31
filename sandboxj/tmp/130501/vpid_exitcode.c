#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <dirent.h>

typedef struct {
	pid_t vpid;
	int rc;
} vpid_rc_t;

void get_vpid_exitcode(char *path, char *filename, vpid_rc_t *vpid_rc)
{
	char fullpath[1024];
	char tmp[1024];
	FILE *fp;
	char line[1024];

	if (NULL != strstr(filename, "err")) {
		strncpy(tmp, filename, strlen(filename) - strlen("_err"));
		vpid_rc->vpid = atoi(tmp);
	} else {
		vpid_rc->vpid = atoi(filename);
	}


	sprintf(fullpath, "%s/%s", path, filename);
	if (NULL == (fp = fopen(fullpath, "r"))){
		perror("fopen");
		exit(1);
	}

	if (NULL == fgets(line, 1024, fp)) {
		perror("fgets");
		exit(1);
	}

	vpid_rc->rc = atoi(line);
	fclose(fp);
}

int main() {
	char *default_root_dir = "/tmp/hamster2";
	char *jobid = "jobid_12345";

	char path[1024];
	DIR *dir;
	struct dirent *d_entry;
	vpid_rc_t vpid_rc;

	sprintf(path, "%s/%s", default_root_dir, jobid);

	if (NULL == (dir = opendir(path))) {
		perror("opendir");
		exit(1);
	}

	while(NULL != (d_entry = readdir(dir)))	{
		if (0 == strcmp(d_entry->d_name, ".") || 0 == strcmp(d_entry->d_name, ".."))
		continue;

		get_vpid_exitcode(path, d_entry->d_name, &vpid_rc);
		printf("name = %s/%s, vpid = %d, rc = %d\n", path, d_entry->d_name, vpid_rc.vpid, vpid_rc.rc);
	}

	closedir(dir);
	return 0;
}

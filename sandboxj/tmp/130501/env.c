#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

extern char **environ;

int main()
{
	char **tmp;

	tmp = environ;
	while(*tmp) {
		printf("%s=%s\n", *tmp, getenv(*tmp));	
		tmp++;
	}

	setenv("MYHOME", "XIAN", 1);

	
	puts("===============================");
	tmp = environ;
	while(*tmp) {
		printf("%s=%s\n", *tmp, getenv(*tmp));
		tmp++;
	}
	return 0;
}

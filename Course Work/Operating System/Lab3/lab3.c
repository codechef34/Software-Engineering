#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h> /* standard libraries */
int main()
{
      pid_t pid; /* variable pid which stores process id */
      //fork a child process
      pid=fork(); /* call for fork function to create child process */
      if(pid<0) /* pid should be greater than or equals zero if not it
is error*/
      {
            fprintf(stderr, "Fork Failed");// error occured
            exit(-1);
      }
      else if(pid==0) /*if pid is zero,it means child process is ceeated*/
      {
            execlp("/bin/uname","uname",NULL);//child process
                                        // uname program prints operating system name
      }
      else
      {
            wait(NULL);//parent will wait for the child process to complete
            printf("Child Complete");
            exit(0);
      }
}
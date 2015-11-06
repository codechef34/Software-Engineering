#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<sys/types.h>
#define MAXLINE 20
#define SERV_PORT 5777 main(int argc,char *argv)
{
char sendline[MAXLINE],revline[MAXLINE];
int sockfd;
struct sockaddr_in servaddr;

sockfd=socket(AF_INET,SOCK_STREAM,0); bzero(&servaddr,sizeof(servaddr)); servaddr.sin_family=AF_INET; servaddr.sin_port=ntohs(SERV_PORT);
connect(sockfd,(struct sockaddr*)&servaddr,sizeof(servaddr));
printf("\n enter the data to be send");

                                                                            
                                                                  


while(fgets(sendline,MAXLINE,stdin)!=NULL)
{ 







}
exit(0);
}

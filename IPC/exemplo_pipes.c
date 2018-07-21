#include<sys/types.h>
#include<stdio.h>
#include<string.h>
#include<unistd.h>

#define BUFFER_SIZE 25
#define READ_END 0
#define WRITE_END 1

int main(void)
{
	char write_msg[BUFFER_SIZE] = "Hello World!";
	char read_msg[BUFFER_SIZE];	
	int fd[2];
	pid_t pid;
	
	if (pipe(fd) == -1)
	{
		fprintf(stderr, "Pipe failed");
		return 1;
	}
	
	pid = fork();
	
	if (pid < 0)
	{
		fprintf(stderr, "Fork failed");
		return 1;
	}
	
	if (pid > 0)
	{
		while(1)
		{
			write(fd[WRITE_END], write_msg, strlen(write_msg)+1);
			sleep(rand()%5);
			
		}
		close(fd[WRITE_END]);	
	} 
	else
	{
		while(1)
		{
			read(fd[READ_END], read_msg, BUFFER_SIZE);
			printf("read %s\n", read_msg);
			sleep(rand()%5);
		}
		close(fd[READ_END]);			
	} 
	return 0;
}
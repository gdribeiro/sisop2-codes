#include <stdio.h>
#include <pthread.h>

int g;


pthread_mutex_t m

void *do_it_1(void *arg) {
    int i, n = *(int *) arg;
    for(i = 0; i < n; i++)
	pthread_mutex_lock(&m);
        g = i;
	printf("%d\n", 1);
	pthread_mutex_unlock(&m);
}

void *do_it_2(void *arg) {
    int i, n = *(int *) arg;
    for(i = 0; i < n; i++)
	pthread_mutex_lock(&m);
        printf("%d\n", g);
	pthread_mutex_unlock(&m);
}

int main( int argc, char **argv) {
    pthread_t th1, th2;
    int n = 10;
	m = 1;

    pthread_create(&th1, NULL, do_it_1, &n);
    pthread_create(&th2, NULL, do_it_2, &n);
	
	pthread_join(th1, NULL);
	pthread_join(th2, NULL);


	
	printf("acabando...\n");
	// Wits for all threads to finish execution	
	//pthread_exit(NULL);

}

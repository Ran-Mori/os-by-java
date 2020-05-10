#include <iostream>
#include <zconf.h>

using namespace std;
int main ()
{
    //pid_t fpid; //fpid表示fork函数返回的值
    int id=fork();
    if (id > 0){
        printf("主进程：A\n");
        int id=fork();
        if (id==0)
            printf("子进程二：C\n");
    }

    else if (id == 0) {
        printf("子进程一：B\n");
    }
    else
        printf("error in fork!\n");
    return 0;
}

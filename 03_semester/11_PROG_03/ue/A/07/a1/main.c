#include <stdio.h>

void print(void)    { printf("Hallo\n"); }
void print2(int i)  { printf("%d\n", i); }

void times(int n, void (*verarbFunc)(void)){
    for (int i = 0; i < n; i++){
        (*verarbFunc)();
    }
}
void times2(int n, void (*verarbFunc)(int)){
    for (int i = 0; i < n; i++){
        verarbFunc(i);
    }
}

int main(void) {
    times(3,print);
    times2(3,print2);
    return 0;
}
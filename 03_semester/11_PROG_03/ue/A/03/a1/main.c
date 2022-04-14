#include <stdio.h>
#include <string.h>
#include <stdint.h>

int main(void) {
    printf("char : %lu\n", sizeof(char));     
    printf("pointer : %lu\n", sizeof(int *));
    printf("string : %lu\n", sizeof("hello"));
    printf("short : %lu\n", sizeof(short));
    printf("int : %lu\n", sizeof(int));
    printf("double : %lu\n", sizeof(double));
    printf("float : %lu\n", sizeof(float));
    printf("long double: %lu\n", sizeof(long double));
}
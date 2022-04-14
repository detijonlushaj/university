#include <stdio.h>

int get_input(char prompt[]) {
    int x;
    printf("%s", prompt);
    scanf("%d", &x);
    return x;
}
#include <stdio.h>

int get_input(char prompt[]){
    int i;
    printf("%s",prompt);
    scanf("%d",&i);
    return i ;
}

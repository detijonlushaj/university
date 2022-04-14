#include <stdio.h>
#include "int20.h"

void print20(struct int20 obj){

    int cnt = 0;
    while(obj.number[cnt] == '0') {
        cnt++;
    }

    for( int i = cnt; i< LEN; i++){
        printf("%c",obj.number[i]);
    }
}

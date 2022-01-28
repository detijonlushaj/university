#include "create20.h"
#include "int20.h"
#include "string.h"
#include <stdio.h>

struct int20 create20(char val[]) {
    struct int20 x = {"00000000000000000000"};         //intis
    int cnt = 0;
    
    while (cnt <= strlen(val)-1 ) {
        x.number[LEN-strlen(val)+cnt] = val[cnt];
        cnt++;
    }
    return x;
}

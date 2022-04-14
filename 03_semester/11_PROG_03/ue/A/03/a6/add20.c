#include <stdio.h>
#include <string.h>
#include "int20.h"
#include "print20.h"

struct int20 add20(struct int20 a, struct int20 b) {

    struct int20 x;
    int summandA;
    int summandB;
    int sum;
    int rest = 0;

    for (int i = LEN - 1 ; i >= 0; i--){
        summandA = (a.number[i] - '0');
        summandB = (b.number[i] - '0');
        sum = summandA + summandB + rest;

        rest = sum/10;

		x.number[i] = (sum%10) + 48;
    }
    return x;
}

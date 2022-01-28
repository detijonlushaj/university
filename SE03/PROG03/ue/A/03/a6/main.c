#include <stdio.h>
#include "int20.h"
#include "create20.h"
#include "print20.h"
#include "add20.h"

int main(void) {

    printf("\n");
    struct int20 a1= create20("12345678901234567890");
    struct int20 b1= create20("100");
    struct int20 sum1= add20(a1, b1);
    print20(a1); printf("\n");
    print20(b1); printf("\n");
    print20(sum1); printf("\n"); 
    
    printf("\n");
    struct int20 a = create20("9700");
    struct int20 b = create20("422");
    struct int20 sum = add20(a, b);
    print20(a); printf("%c", '\n');
    print20(b); printf("%c", '\n');
    print20(sum); printf("%c", '\n'); 
    
    printf("\n");
    return 0;
    
}

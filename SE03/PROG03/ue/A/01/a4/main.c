#include <stdio.h>
#include "quadrat.h"

int main(void) {
    int n;
    printf("%s", "enter a number: ");
    scanf("%d", &n);
    printf("your number squared: %d", quadrat(n));
    return 0;
}
#include <stdio.h>
#include "summe.h"
#include "differenz.h"

void berechne(void) {
    char operation;
    int result = -1;

    do {
        printf("%s", "Ihre Wahl:\n<S>umme oder <D>ifferenz? ");
        // whitespce important due to \n still in buffer
        // this step only necessary if first input was wrong
        scanf(" %c", &operation);

        if(operation == 'S' || operation == 's') {
            result = summe();
        } else if (operation == 'D' || operation == 'd') {
            result = differenz();
        }
    } while (result == -1);

    printf("Ergebnis: %d", result);
}

int main(void) {
 berechne();
 return 0;
}
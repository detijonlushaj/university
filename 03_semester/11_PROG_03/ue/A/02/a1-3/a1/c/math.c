#include <stdio.h>
#include "summe.h"
#include "differenz.h"
#include <stdbool.h>
#include "def.h"

void berechne(void) {
    char operation;
    int result;
    bool next = false;

    do {
        printf("%s", "Ihre Wahl:\n<S>umme oder <D>ifferenz? ");
        // whitespce important due to \n still in buffer
        // this step only necessary if first input was wrong
        scanf(" %c", &operation);

        if(operation == 'S' || operation == 's') {
            result = summe();
            next = true;
        } else if (operation == 'D' || operation == 'd') {
            result = differenz();
            next = true;
        }
    } while (next == false);

    printf("Ergebnis: %d\n", result);
}

int main(void) {
 berechne();
 printf("%s", PROJECT_NAME);
 return 0;
}
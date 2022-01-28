#include <stdio.h>
#include "summe.h"
#include "differenz.h"

void berechne(void) {

    char input = 0;
    int ergebnis = 0;
    do {
        printf("\nIhre Wahl:\n <S>umme oder <D>ifferenz? ");
        scanf("%c",&input);
    } while ( !(input == 'S' || input == 'D'));

    if(input == 'S'){
        ergebnis = summe();
    } else if ( input == 'D') {
        ergebnis = differenz();
    }

    printf("Ergebnis: %d\n",ergebnis );
}

int main(void) {
    berechne();
    return 0;
}

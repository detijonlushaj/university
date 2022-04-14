#include <stdio.h>

void output(void){
    printf("Ihre Eingabe\n");
    printf("\t<funktion> [<betrag>]\n");
    printf("Bedeutung von <funktion>: 0=Mwst. vom Netto, 1=Brutto vom Netto, 2=Netto vom Brutto, 3=Ende\n");
    printf("z. B. 0 99.95\t (für die Berechnung der Mehrwertsteuer von 99.95 netto)\n");
}

void mwstNetto(double x) {                          //0=Mwst. vom Netto
    printf("Mwst. vom Netto: %.2f\n\n", (x*0.19));
}
void mwstBrutto(double x) {                         //1=Brutto vom Netto
    printf("Brutto vom Netto: %.2f\n\n", (x*1.19));
}
void Netto2Brutto(double x) {                       //2=Netto vom Brutto
    printf("Netto vom Brutto: %.2f\n\n", (x/1.19));
}

int main(void){
    int fnk = -1;
    double x =0;
    void (*funktionen[3])(double) = {mwstNetto,mwstBrutto,Netto2Brutto}; 

    do{
        output();
        scanf("%d", &fnk);
        if (fnk == 3) break;
        scanf(" %lf", &x);

        (*funktionen[fnk])(x);
    } while( fnk >=0 && fnk <=2);
}

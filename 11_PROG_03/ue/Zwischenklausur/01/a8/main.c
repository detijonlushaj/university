#include <stdio.h>
#include <stdlib.h>

/* Die folgende Funktion kopiert den Wert i in einen neu allokierten
   Freispeicherbereich und liefert einen Zeiger auf diesen Bereich
   zurück */
int* allocate(int i) {
    int* p = (int*)malloc(sizeof(int));
    *p =i;
    return p;
}
/* Hier ergänzen Sie bitte eine Funktion deallocate mit einer
   Zeigervariable als Parameter, die den durch die Zeigervariable
   referenzierten Freispeicherbereich frei gibt. */
void deallocate(int *p) {
    free(p);
    p = NULL;
}

int main(void) {
    int* p = allocate(10);
    printf("%d\n",*p);
    /* hier fehlt Ihr Code (Ausgabe des von p referenzierten Werts) */
    deallocate(p);
    return 0; 
}

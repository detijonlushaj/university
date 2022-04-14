/* main.c */
#include <stdio.h>
int main(void) {
    int a[]= { 1, 5, 19, -4, 3 };
    int* p;
    int i;
    /* Lasse p auf das 0-te Array-Element verweisen. */
    /* Ihr Code hier */
    p = &a[0]; // p = a

    for (i=1; i<5; i++) {
        /* Prüfe, ob das Array-Element i größer als das von p referenzierte Element ist */ 
        if ( *p < a[i]) {
            /* Lasse p auf das Array-Element i verweisen */
            /* Ihr Code hier */
            p = &a[i];
        } 
    }

    /* Gib das von p referenzierte Element als das größte aus: */ 
    printf("Maximum: %d\n", *p/* Ihr Code hier */ );
    return 0;
}
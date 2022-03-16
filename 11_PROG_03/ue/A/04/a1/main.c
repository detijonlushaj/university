#include <stdio.h> 
#include <string.h>
#include "printmemory.h"

#ifndef SH
#define SH
struct beispiel {
    short i;
    int j;
    char s[10];
};
#endif
// c.)
void fill(char u[]) {
    *(short *)u = 89;
    *(int *)(u+4) = 32168;
    strcpy(u+9,"Rosi");
}

int main(void) {
    struct beispiel bsp1;
    bsp1.i = 0x0102;
    bsp1.j = 0x11121314; 
    strcpy(bsp1.s, "XXXXXXXXX"); 
    printmemory(&bsp1, sizeof(bsp1));

      /* Die Struktur wird in ein Char-Array umgewandelt
     und der fill-Funktion uebergeben. */
    struct beispiel bsp;
    fill((char*)&bsp);

    printf("%d %d %s\n", bsp.i, bsp.j, bsp.s);
    return 0; 
}


/**
 * a.)  2 Byte fuer short + 2 Bytes fuers Padding + 4 Bytes fuer int  + 2 Byte fuers Padding + 10 Byte = ISNG 20 Bytes 
 * 
 * b.) Ja auf 16 Byte wenn wir 
 *  struct beispiel {
 *      char s[10];
 *      short i;
 *      int j;
 *  };
 * 
 */



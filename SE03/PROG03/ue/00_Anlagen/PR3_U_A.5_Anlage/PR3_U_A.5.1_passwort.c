
#include <stdio.h>
#include <string.h>

int main(void) {
    char passwort[32] = "GeHeIm";  /* Dem Programmbenutzer unbekannt */
    char eingabe[32] = "";

    /* Ggf. muessen Sie die Reihenfolge der beiden vorstehenden 
       Array-Definitionen umkehren, um den unten beschriebenen Effekt
       zu beobachten (plattformabhaengig). Auf den Pool-PCs ist die obige
       Reihenfolge die richtig, um den gewuenschten Effekt zu beobachten.
    */

    printf("eingabe[] = %s\n", eingabe);
    printf("passwort[] = %s\n", passwort);

    printf("Bitte Passwort fuer den Hochsicherheitsbereich eingeben:\n");

    /* read all including spaces and tabs to the end of the line */
    scanf("%[^\n]", eingabe);

    if (!strncmp(eingabe, passwort, strlen(passwort))) {
      printf("Passwort korrekt - Willkommen im Hochsicherheitsbereich!\n");
      return 0;
    } else {
      printf("Passwort falsch - Zugang verweigert!\n");
      return -1;
    }
}

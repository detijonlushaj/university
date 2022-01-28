#include <stdio.h>
#include <stdlib.h>
#define NAME_LEN 40
typedef struct {
    char name[NAME_LEN+1];
    int personalnummer;
    float gehalt;
} angestellter;

void clear (void) {    
  while ( getchar() != '\n' );
}

int main(void) {
    angestellter* arr[10] = {NULL};
    int bool = 1;
    int i;

    do {
        printf("Bitte waehlen Sie einen Benutzer aus [1,10]: ");
        scanf("%d",&i);

        if(arr[i] != NULL) {
            free(arr[i]);
            arr[i] = NULL;
            printf("Angestellter %d wurde geloescht!", i);
        }

        arr[i] = (angestellter*)malloc(sizeof(angestellter));

        printf("Name: ");
        scanf("%40s[^\n]",arr[i]->name);
        clear();

        printf("Personalnummer: ");
        scanf("%d",&arr[i]->personalnummer);
        clear();

        printf("Gehalt: ");
        scanf("%f",&arr[i]->gehalt);
        clear();

        for (int i = 0; i < 10; i++) {
            if(arr[i] != NULL){
                printf("Name: %s\nPersonalnummer: %d\nGehalt: %f\n\n",arr[i]->name,arr[i]->personalnummer,arr[i]->gehalt);
            }
        }
        

        char c;
        do {
            printf("Wollen Sie noch einen Eintrag aendern/hinzufuegen (j / n):");
            scanf("%c",&c);
            clear();
            if(c == 'n' ) bool = 0;
            if(c == 'j' ) bool = 1;
        } while( !((c != 'n' && c == 'j') || (c == 'n' && c != 'j')) );

    } while(bool == 1);
    return 0;
}
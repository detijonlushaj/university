#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define N_ANGEST 5
#define LEN 20

typedef struct {
    char name[LEN+1];
    int personalnummer;
    float gehalt;
} angestellter ;

static const char FILE_NAME[] = "angestellte.dat";

angestellter init_angest(char name[], int pn, float gehalt) {
    angestellter angest;
    strcpy(angest.name, name);
    angest.personalnummer = pn;
    angest.gehalt = gehalt;
    return angest;
}

void binaer_speichern(angestellter arr[],int anz){
    FILE *f = fopen(FILE_NAME, "wb");                   // file oeffnen - write-binary
    fwrite(&anz, sizeof(anz), 1, f);                    // (adresse wann er anfangen soll zu lesen,block-groesse,anzahl,file)
    fwrite(&arr[0], sizeof(angestellter), anz, f);      // same 
    fclose(f);
}

void binaer_laden_und_ausgeben(void){
    FILE *f = fopen(FILE_NAME, "rb");               //read binary
    int laenge;                                     // (adresse wann er anfangen soll zu schreiben,block-groesse,anzahl,file)
    fread(&laenge, sizeof(laenge), 1, f);       
    angestellter *angest_ptr = malloc(laenge * sizeof(*angest_ptr));
    fread(angest_ptr, sizeof(*angest_ptr), laenge, f);
    fclose(f);

    for (int i = 0; i < laenge; ++i) {
        printf("%s, %d, %0.2f\n", angest_ptr[i].name, angest_ptr[i].personalnummer, angest_ptr[i].gehalt);
    }
}

int main(void){
    angestellter angest[N_ANGEST];
    angest[0] = init_angest("Schehat", 1, 1000);
    angest[1] = init_angest("Deti", 2, 2000);
    angest[2] = init_angest("Furkan", 3, 3000);
    angest[3] = init_angest("Hien", 4, 4000);
    angest[4] = init_angest("Aland", 5, 5000);

    binaer_speichern(angest,N_ANGEST);
    binaer_laden_und_ausgeben();
}




// void binaer_speichern(struct angestellter arr[],int anz){
//     FILE *fp = fopen(FILE_NAME, "w");
//     fprintf(fp, "%d\n", anz);
//     for(int i=0; i<anz; i++) {
// 		fprintf(fp, "%s\t%d\t%f\n", arr[i].name,arr[i].personalnummer,arr[i].gehalt);
// 	}
// 	printf("Alles wurde erfolgreich reingeschrieben.\n");
// 	fclose(fp);
// }

// void binaer_laden_und_ausgeben(void){
//     FILE *fp  = fopen(FILE_NAME, "r");
//     int i, temp;
//     while((temp = fgetc(fp))!=EOF) {
// 	    printf("%c", temp);
// 	}
// 	fclose(fp);
// }
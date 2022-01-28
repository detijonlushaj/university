#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <stdio.h>
#define N_ELEMS 100

int randomNumber(int hi)  /* Rückgabe in {0,1,...,hi-1} */
{
    const double scale = rand()/((double)RAND_MAX+1.0);
    int i = (int)(scale*hi);
    /* falls wegen Rundungsfehlern der gewünschte Wertebereich ueberschritten wurde: eingrenzen */
    return (i >= hi ? hi - 1 : i);
}

int intCompare(const void* i1p, const void* i2p) { 
    return *(int*)i1p - *(int*)i2p;
}



typedef struct {
    char name[15]; /* Platz fuer Schmidt_1234 */
    int gehalt;
} angestellter;


int angCompare(const void* a1p, const void* a2p) {
    return ((angestellter*)a1p)->gehalt - ((angestellter*)a2p)->gehalt;
}

int main(void) {
    // int arr[N_ELEMS];
    // for (int i = 0; i < N_ELEMS; i++) {
    //     arr[i] = randomNumber(1000)+1;
    //     printf("ARR[%d] = %d\n", i, arr[i]);
    // }
    // printf("\n\n\n");

    // qsort(arr, N_ELEMS, sizeof(int), intCompare);

    // for (int i = 0; i < N_ELEMS; i++) {
    //     printf("ARR[%d] = %d\n", i, arr[i]);
    // }
    //-----------------------------------
    angestellter angs[N_ELEMS];
    char nAsString[] = "0000";

    for (int i = 0; i < N_ELEMS; ++i) { 
        strcpy(angs[i].name, "Schmidt_"); 
        sprintf(nAsString, "%d", randomNumber(1000)); 
        strcat(angs[i].name, nAsString); 
        angs[i].gehalt = 2000 + randomNumber(4001);
        printf("Angestellter: %s, Gehalt: %d\n",angs[i].name,angs[i].gehalt);
    }
    qsort(angs, N_ELEMS, sizeof(angestellter), &angCompare);
    
    for (int i = 0; i < N_ELEMS; ++i) { 
        printf("Angestellter: %s, Gehalt: %d\n",angs[i].name,angs[i].gehalt);
    }

}
#include <stdio.h>

void tausche_intPtr(int** p1, int** p2) {
    int* temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

void tausche_int(int* p1, int*p2) {
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}


int main(void) {
  int i = 1; 
  int j = 2;
  printf("i = %d, j = %d\n", i, j); /* Gibt 1 und 2 aus */ 
  tausche_int(&i, &j);
  printf("i = %d, j = %d\n", i, j); /* Gibt 2 und 1 aus */

  int *ptri = &i;
  int *ptrj = &j; 
  printf("ptri = %p, ptrj = %p\n", ptri, ptrj);
  tausche_intPtr(&ptri, &ptrj);
  printf("ptri = %p, ptrj = %p\n", ptri, ptrj);

  return 0; 
}

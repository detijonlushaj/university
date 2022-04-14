#include <stdio.h>

void printInts(int row[], int n) {
  int i;
  for (i = 0; i < n; ++i)
    printf("%d ", row[i]);
  printf("\n");
}

void printLayer(int b[][5], int nRows) {
  int row;
  for (row = 0; row < nRows; ++ row)
    printInts(b[row], 5);
  printf("\n");
}

void printBlock(int a[][3][5], int nLayers) {
  int layer;
  for (layer = 0; layer < nLayers; ++layer)
    printLayer(a[layer], 3);
}

int main(void) {
  int a[2][3][5] = {
    /* Ein Quader aus 2 Schichten, die jeweils aus 3 Reihen 
       von je 5 ints bestehen */
    {
      {111, 112, 113, 114, 115},
      {121, 122, 123, 124, 125},
      {131, 132, 133, 134, 135}
    },
    {
      {211, 212, 213, 214, 215},
      {221, 222, 223, 224, 225},
      {231, 232, 233, 234, 235}
    }
  };
  printBlock(a, 2);
  return 0;
}
    
  

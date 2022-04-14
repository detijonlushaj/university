#include <stdio.h>

#include "printmemory.h"

int main(void)
{
  unsigned char a[128];
  unsigned char b[128] = { 4, 7, 1, 1 }; 
  printf("Uninitialisiertes Array:\n");
  printmemory(a, 128);
  printf("Initialisiertes Array:\n");
  printmemory(b, 128);
  return 0;
}


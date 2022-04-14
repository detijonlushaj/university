#include "printmemory.h"

#include <stdio.h>

void printmemory(void* address, size_t size)
{
  int i = 0;
  unsigned char* a = (unsigned char*)address;
  for (i=0; i < size; ++i)
  {
    const int columns = 16;
    if (i%columns == 0)
      printf("%p:", a + i);
    printf(" %02hx", a[i]);
    if (i%columns == columns-1 || i == size-1)
      printf("\n");
  }
}



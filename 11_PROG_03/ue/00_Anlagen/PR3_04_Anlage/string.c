#include <stdio.h>
#include <string.h>

#include "printmemory.h"

int main(void)
{
  char name[] = "Prog";
  printf("%s\n", name);
  printmemory(name, 256);
  name[4] = 'X';
  name[5] = 'X';
  printf("%s\n", name);
  printmemory(name, 256);
  
  return 0;
}


#include <stdio.h>

#include "printmemory.h"

struct s
{
  unsigned char a;
  int b;
};

int main(void)
{
  struct s x[2] = { {0xaa, 0xbbccddee}, {0xff, 0xdeadbeef} };
  printf("sizeof(s) = %lu\n", sizeof(struct s));
  printmemory(x, 2*sizeof(struct s));
  return 0;
}


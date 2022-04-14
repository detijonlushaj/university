#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int i;
  i = atoi("Hello");
  printf("Hello -> %d\n", i);
  i = atoi("123");
  printf("123 -> %d\n", i);
  i = atoi("123Hello");
  printf("123Hello -> %d\n", i);
  return 0;
}


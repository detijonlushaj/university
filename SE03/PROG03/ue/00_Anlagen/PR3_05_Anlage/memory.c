#include <stdio.h>
#include <stdlib.h>

const int konstante = 42;
int global = 0;


void myfunc(int depth)
{
  if (depth == 0)
    return;
  printf("%d: &depth=%p\n", depth, (void*)&depth);
  myfunc(depth - 1);
}

int main(void)
{
  const char *const string = "Test";
  const int local = 0;
  void* heap = malloc(2048);
  printf("&konstante=%p\n", (void*)&konstante);
  printf("&global=%p\n", (void*)&global);
  printf("&local=%p\n", (void*)&local);
  printf("string=%p\n", (void*)&string);
  printf("heap=%p\n", (void*)heap);
  myfunc(20);
  free(heap);
  return 0;
}


#include <stdio.h>

#include "printmemory.h"

struct test
{
  unsigned int caffee0;
  unsigned int caffee1;
  unsigned int caffee2;
  unsigned int caffee3;
  unsigned char a[128];
  unsigned int caffee4;
  unsigned int caffee5;
  unsigned int caffee6;
  unsigned int caffee7;
};

int main(void)
{
  struct test t;
  t.caffee0 = 0xcaffee00;
  t.caffee1 = 0xcaffee01;
  t.caffee2 = 0xcaffee02;
  t.caffee3 = 0xcaffee03;
  t.caffee4 = 0xcaffee04;
  t.caffee5 = 0xcaffee05;
  t.caffee6 = 0xcaffee06;
  t.caffee7 = 0xcaffee07;
  printf("&caffee0 = %p\n", (void*)&t.caffee0);
  printf("&caffee1 = %p\n", (void*)&t.caffee1);
  printf("&caffee2 = %p\n", (void*)&t.caffee2);
  printf("&caffee3 = %p\n", (void*)&t.caffee3);
  printf("&caffee4 = %p\n", (void*)&t.caffee4);
  printf("&caffee5 = %p\n", (void*)&t.caffee5);
  printf("&caffee6 = %p\n", (void*)&t.caffee6);
  printf("&caffee7 = %p\n", (void*)&t.caffee7);
  printmemory(t.a, 144);
  return 0;
}


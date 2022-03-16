#include <stdio.h>

struct beispiel
{
  short i;
  int j;
  char s[10];
};

void fill(char u[])
{
  /* Hier soll Ihr Code eingefuegt werden. */
}

int main(void)
{
  struct beispiel bsp;

  /* Die Struktur wird in ein Char-Array umgewandelt
     und der fill-Funktion uebergeben. */
  fill((char*)&bsp);

  printf("%d %d %s\n", bsp.i, bsp.j, bsp.s);
  return 0;
}


#include <stdio.h>

char bytes[0x1000000000000000];

int main(void) {
  printf("Startadresse der Variablen: %p\n", bytes);
  return 0;
}

#include <stdio.h>
#include <stdlib.h>

void free0(char **p){
    free(*p);
    *p = NULL;
}


int main(void) {
  char* p = malloc(10);
  printf("%p\n", p); /* Ausgabe z. B. 0x470228 */
  free0(&p);
  printf("%p\n", p); /* Ausgabe 0x0 oder 0 oder (nil) o. ä. */
  return 0;
}
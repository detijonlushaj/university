#include <stdio.h>
#include <string.h>

#include "mystrcat.h"

int main(void) {
  char buffer[30];
  char nonempty[] = "Informatik";
  char empty[] = "";
  char exclaim[] = "!";

  strcpy(buffer, "Angewandte ");
  mystrcat(buffer, empty);
  printf("buffer = %s\n", buffer); /* "Angewandte " */

  mystrcat(buffer, nonempty);
  printf("buffer = %s\n", buffer); /* "Angewandte Informatik" */

  mystrcat(buffer, exclaim);
  printf("buffer = %s\n", buffer); /* "Angewandte Informatik!" */

  strcpy(buffer, "");
  mystrcat(buffer, nonempty);
  printf("buffer = %s\n", buffer); /* "Informatik" */

  return 0;
}

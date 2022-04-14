#include <stdio.h>
#include <stdlib.h>

struct character
{
  char c;
  struct character* next;
};
typedef struct character string;

string* create_string(char* str)
{
  string* first = NULL;

  /* Hier sollen Sie Ihren Code einfuegen. */

  return first;
}

void delete_string(string* str)
{
  /* Hier sollen Sie Ihren Code einfuegen. */
}

void print_string(string* str)
{
  /* Hier sollen Sie Ihren Code einfuegen. */
}

int main(void)
{
  string* test = create_string("Hallo String!");
  print_string(test);
  free_string(test);
  return 0;
}


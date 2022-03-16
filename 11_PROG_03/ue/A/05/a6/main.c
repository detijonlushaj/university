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
  struct character* current = NULL; 
  struct character* previous = NULL; 
  while (*str != '\0') {
    current = (struct character*)malloc(sizeof(struct character)); 
    current->c = *(str++);
    current->next = NULL;
    if (previous != NULL)
      previous->next = current; 
    previous = current;
    if (first == NULL)
      first = current;
  }
  return first;
}

void delete_string(string* str)
{
  while (str != NULL) {
    struct character* next = str->next; 
    free(str);
    str = next;
  }
}

void print_string(string* str)
{
  while (str != NULL) {
    printf("%c", str->c);
    str = str->next;
  }
}

int main(void)
{
  string* test = create_string("Hallo String!");
  print_string(test);
  delete_string(test);
  return 0;
}


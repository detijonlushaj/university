#include <stdio.h>

struct user
{
  char name[10];
  int admin;
};

int main(void)
{
  struct user u = { "", 0 };
  printf("Name: ");
  fgets((char*)&u.name, 10, stdin);
  //scanf("%s", (char*)&u.name);  //wenn man mehr als 13 zeichen eingibt  da hintere name noch zwei padding bytes drin sind
  printf("Hallo %s!\n", u.name);
  if (u.admin)
	  printf("Gratulation! Sie sind Admin!\n");
  return 0;
}


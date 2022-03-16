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
  scanf("%s", (char*)&u.name);
  printf("Hallo %s!\n", u.name);
  if (u.admin)
	  printf("Gratulation! Sie sind Admin!\n");
  return 0;
}


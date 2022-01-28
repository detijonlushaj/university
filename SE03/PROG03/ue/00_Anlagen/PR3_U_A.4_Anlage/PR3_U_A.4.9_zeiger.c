// Aufgabe 9  a)
#include <stdio.h>
void main()
{
  int a[3] = {1, 2, 3};
  int *p = a;
  printf("%p %p", p, a);
}

// Aufgabe 9 b)
#include <stdio.h>
void main()
{
  char *s = "Hallo";
  char *p = s;
  printf("%p %p", p, s);
}

// Aufgabe 9 c)
#include <stdio.h>
void main()
{
  char *s= "Hallo";
  char *p = s;
  printf("%c %c", p[0], s[1]);
}

// Aufgabe 9 d)
#include <stdio.h>
void main()
{
  char *s= "Hallo";
  char *p = s;
  printf("%c %c", *(p + 3),  s[1]);
}

// Aufgabe 9 e)
#include <stdio.h>
void main()
{
  char *s= "Hallo";
  char *p = s;
  printf("%c %c", 1[p], s[1]);
}

// Aufgabe 9 f)
#include <stdio.h>
void foo( int[] );
int main()
{
  int a[4] = {1, 2, 3, 4};
  foo(a);
  printf("%d ", a[0]);
}
void foo(int* p)
{
  int i = 10;
  p = &i;
  printf("%d ", p[0]);
}

// Aufgabe 9 g)
#include <stdio.h>
int main()
{
  int a[4] = {1, 2, 3, 4};
  int *p = a + 3;
  printf("%d\n", p[-2]);
}

//Aufgabe 9 h)
#include <stdio.h>
int main()
{
  int a[4] = {1, 2, 3, 4};
  int *p = a + 3;
  printf("%d %d\n", p[-2], a[*p]);
}

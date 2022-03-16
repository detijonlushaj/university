#include <stdio.h>

#define psizeof(type) printf("sizeof(" #type ") = %lu\n", sizeof(type));

int main(void)
{
  psizeof(short);
  psizeof(int);
  psizeof(long);
  psizeof(float);
  psizeof(double);
  psizeof(long double);
  psizeof(char);
  psizeof(void*);
  return 0;
}


#include <stdio.h>

#define psizeof(type) printf("sizeof(" #type ") = %lu\n", sizeof(type));

#define mysizeof(type) (char *)(&type+1)-(char*)(&type) 

int main(void)
{
  long double test;
  psizeof(short);
  psizeof(int);
  psizeof(long);
  psizeof(float);
  psizeof(double);
  psizeof(long double);
  psizeof(char);
  psizeof(int*);
  
  printf("mysizeof(test)=%ld\n", mysizeof(test));

  return 0;
}


#include <math.h>
#include <stdio.h>

double square(double x)
{
  return x*x;
}

void printvalues( double (*func)(double) )
{
  double x;
  for (x = 0.0; x < 1.0; x += 0.1)
  {
    printf("%f -> %f\n", x, (*func)(x));
  }
}

int main(void)
{
  printf("square\n");
  printvalues(&square);

  printf("sin\n");
  printvalues(&sin);
  
  printf("cos\n");
  printvalues(&cos);
  
  return 0;
}

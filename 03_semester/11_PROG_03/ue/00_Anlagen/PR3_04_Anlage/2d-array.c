#include <stdio.h>

void mult_table_init(int a[][10], int N) {
  for (int i = 0; i < N; ++i) {
     for (int j = 0; j < 10; ++j) {
       a[i][j] = (i+1) * (j+1);
     }
  }
}

int main(void) {
#define N_ROWS 20
  int numbers[20][10];
  mult_table_init(numbers, sizeof(numbers) / sizeof(numbers[0]));  
                                               // sizeof-Ausdruck ist sauberer als einfach 20
  for (int i = 0; i < N_ROWS; ++i) {   // auch ein #define ist besser als einfach 20
     for (int j = 0; j < 10; ++j) {
       printf("%.3d ", numbers[i][j]);
     }
     printf("\n");
  }
}

  

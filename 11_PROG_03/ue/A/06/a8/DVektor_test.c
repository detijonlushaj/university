#include <stdio.h>
#include "DVektor.h"

void printDouble(double* elemPtr) {
  printf("%f ", *elemPtr);
}

int main(void) {
  double data[] = {1.1, 2.2, 3.3};
  DVektor v2;
  DVektor v = create(data, sizeof(data) / sizeof(data[0]));
  process(v, &printDouble);       /* 1.1, 2.2, 3.3 */
  printf("\n");

  v2 = copy(v);
  add(v, v2);
  process(v, &printDouble);       /* 2.2, 4.4, 6.6 */
  printf("\n");
  process(v2, &printDouble);      /* 1.1, 2.2, 3.3 */
  printf("\n");
 
  delete(v);
  delete(v2);

  return 0;
}

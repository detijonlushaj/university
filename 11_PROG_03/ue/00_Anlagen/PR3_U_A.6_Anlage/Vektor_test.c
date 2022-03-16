#include <stdio.h>
#include "Vektor.h"

void printDouble(char* elemPtr, int size) {
  printf("%f ", *(double*)elemPtr);
}

void mulDoubleBy2(char* elemPtr, int size) {
  *(double*)elemPtr *= 2;
}

void printInt(char* elemPtr, int size) {
  printf("%d ", *(int*)elemPtr);
}

void mulIntBy2(char* elemPtr, int size) {
  *(int*)elemPtr *= 2;
}

int main(void) {
  Vektor v2d;
  Vektor vi;
  Vektor v2i;
  double doubleData[] = {1.1, 2.2, 3.3};
  int intData[] = {1, 2, 3};

  Vektor vd = create((char*)doubleData,
		     sizeof(doubleData)/sizeof(doubleData[0]),
		     sizeof(double));
  process(vd, &printDouble);       /* 1.1 2.2 3.3 */
  printf("\n");

  v2d = copy(vd);
  process(vd, &mulDoubleBy2);
  process(vd, &printDouble);       /* 2.2 4.4 6.6 */
  printf("\n");
  process(v2d, &printDouble);      /* 1.1 2.2 3.3 */
  printf("\n");
 
  delete(vd);
  delete(v2d);

  vi = create((char*)intData,
	       sizeof(intData)/sizeof(intData[0]),
	       sizeof(int));
  process(vi, &printInt);       /* 1 2 3 */
  printf("\n");

  v2i = copy(vi);
  process(vi, &mulIntBy2);
  process(vi, &printInt);       /* 2 4 6 */
  printf("\n");
  process(v2i, &printInt);      /* 1 2 3 */
  printf("\n");
 
  delete(vi);
  delete(v2i);

  return 0;
}

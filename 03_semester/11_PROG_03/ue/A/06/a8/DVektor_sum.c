#include <stdio.h> 
#include "DVektor.h"
void printDouble(double* elemPtr) { 
    printf("%f ", *elemPtr);
}
double runningSum = 0;
void sumElem(double* elemPtr) { 
    runningSum += *elemPtr; 
} 
double sum(DVektor v) {
    runningSum = 0; 
    process(v, sumElem); 
    return runningSum;
}
int main(void) {
    double data[] = {1.1, 2.2, 3.3}; 
    DVektor v = create(data, 3);
    sum(v);
    printf("Summe von "); 
    process(v, printDouble); 
    printf(" = %f\n", runningSum); 
    return 0;
}
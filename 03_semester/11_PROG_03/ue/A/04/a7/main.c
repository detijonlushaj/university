#include <stdio.h>
#define LEN 5

void printarr(int a[]){
    for(int i = 0; i< LEN; i++) {
        printf("%3d ", *(a+i));  //a[i]);
    }
    printf("\n");
}

void cpyarr(int a[], int b[]) {
    for(int i = 0; i < LEN; i++) {
        *(b+i) = *(a+LEN-i-1);
        //b[LEN-1-i] = a[i];
    }
}

void init(int a[], int N){
    int zahler = 0;
    for(int i =0; i < N; i++){
        zahler += (i+1);
        a[i] = zahler;
    }
}

int main(void){
    int a[] = {1,2,3,4,5};
    int b[LEN];
    cpyarr(a,b);
    printarr(a);
    printarr(b);

    init(b,LEN);
    printarr(b);
    return 0;

    return 0;
}
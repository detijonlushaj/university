#include <stdio.h>

void printarr(int a[]){
    for(int i = 0; i< 5; i++) {
        printf("%3d ", *(a+i));  //a[i]);
    }
    printf("\n");
}
void init(int a[], int N) {
    int s = 0;
    for (int i = 0; i < N; i++) {
        s += i+1;
        a[i] = s;
    }
    
}

int main(void){
    int a[] = {1,2,3,4,5};
    printarr(a);

    int b[5];
    init(b,5);
    printarr(b);

    return 0;
}
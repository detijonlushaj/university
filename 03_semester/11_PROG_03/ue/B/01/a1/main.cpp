#include <iostream>
#define SIZE 5

using namespace std;

int *createArray(int n) {
    int *arr{new int[n]};       //heap
    return arr;
}

void releaseArray(int *&arr) {      //& cbr 
    delete[] arr;
    arr = nullptr;
}

int main(void) {
    int *arr {createArray(SIZE)};


    for (int i = 0; i < SIZE; i++) {
        arr[i] = i;
        cout << arr[i] << endl;
    }

    releaseArray(arr);

    return 0;
}
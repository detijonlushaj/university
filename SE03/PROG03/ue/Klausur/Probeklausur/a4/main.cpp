#include<iostream>

int incr(int i) {return i+1;}

int iterate(int n, int initVal, int(*func)(int x)){
    for (int i = 0; i < n; i++){
        initVal = func(initVal);
    }
    return initVal;
}

int main(void){
    std::cout << iterate(3, 0, &incr);
    return 0;
}
#include <iostream> 
using namespace std;

void foo(int i, int& ir) {     
    i++; ir++;              //i = 2     x = 2;
    cout << i << ir;        // 2 2 
}

int main(void) {    
    int x = 1;              // x  =1 || y = 2
    int y = 2 ;              
    int& z = x;             //z -> x
    foo(x, z);                 
    cout << x << y << z << endl;    // 2 2 2
    return 0;
}

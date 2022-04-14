#include <iostream>
#include "int20.h"

using namespace std;

ostream &operator<<(ostream &out, const Int20 &num){
    int icnt = 0;
    for (int i = 0; i < 20; i++) {
        if (num.number[i] != '0') {
            icnt = i;
            break;
        }
    }
    for (int i = icnt; i < 20; i++){
        out << num.number[i];
    }
    return out;
}


int main(void) {
    Int20 a{"12345678901234567890"};
    Int20 b{"100"};
    Int20 sum = a + b;

    cout << "Addition: ";
    a.print();
    cout << " + ";
    b.print();
    cout << " = ";
    sum.print();
    printf("\n");

    cout << "Copy-Konstruktor & Zuweisung: ";
    a = b;
    Int20 c{Int20{b}};
    a.print();
    cout << " + ";
    b.print();
    cout << " = ";
    sum = a + b;
    sum.print();
    printf("\n");

    cout << "Addition +=: ";
    sum.print();
    cout << " + ";
    b.print();
    cout << " = ";
    sum += b;
    sum.print();
    printf("\n");

    cout << "Vergleich: ";
    sum.print();
    cout << " < ";
    b.print();
    cout << " => ";
    cout << (sum < b);
    printf("\n");

    cout << "Vergleich: ";
    b.print();
    cout << " < ";
    sum.print();
    cout << " => ";
    cout << (b < sum);
    printf("\n");

    cout << "<< Überladen: ";
    cout << b << " + " << sum << " = " << (b + sum);
    return 0;
}

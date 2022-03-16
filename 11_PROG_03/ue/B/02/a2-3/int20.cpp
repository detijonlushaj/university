#include<string>
#include <iostream>
#include "int20.h"

Int20::Int20():number{"00000000000000000000"}{};

Int20::Int20(const Int20 &x):number{x.number}{};

Int20::Int20(std::string x){
    number = {"00000000000000000000"};
    int cnt = 0;
    while (cnt <= x.length() - 1) {
        number[20 - x.length() + cnt] = x[cnt];
        cnt++;
    }
}

void Int20::print(){
    int icnt = 0;

    // läuft bis zum ersten Index ab der die Zahl beginnt (!= 0 ist) und merkt sich diesen
    for (int i = 0; i < 20; i++)
    {
        if (this->number[i] != '0')
        {
            icnt = i;
            break;
        }
    }

    // druckt ab dem gemerkten Index alle folgenden Zahlen aus
    for (int i = icnt; i < 20; i++)
    {
        std::cout << this->number[i];
    }
}

Int20 Int20::operator + (const Int20& v){
    Int20 result {"00000000000000000000"};
    int rest = 0;
    int sum = 0;

    for (int i = 19; i >= 0; i--) {
        sum = (this->number[i] - '0') + (v.number[i] - '0') + rest;
        result.number[i] = ((sum % 10) + '0');
        rest = sum / 10;
    }
    return result; 
}

Int20 &Int20::operator += (const Int20& v) {
    int rest = 0;
    int sum = 0;

    for (int i = 19; i >= 0; i--) {
        sum = (this->number[i] - '0') + (v.number[i] - '0') + rest;
        this->number[i] = ((sum % 10) + '0');
        rest = sum / 10;
    }
    return *this; 
}

Int20 &Int20::operator = (const Int20& v){
    if (this == &v) return *this;
    number = {"00000000000000000000"};
    for (int i = 0; i < 20; i++){
        number[i] = v.number[i];
    }
    return *this;
}

bool Int20::operator < (const Int20& v){
    for (int i = 19; i >= 0; i--) {
        if ( this->number[i] < v.number[i] ) {
            return true;
        } else if (this->number[i] > v.number[i]){
            return false;
        }
    }
    return false;
}

#include "Person.h"
#include "Ort.h"
#include <string>

Person::Person(Ort * geb, Ort * wohn, int alter, std::string name):geburtsort{geb},wohnort{wohn},alter{alter},name{name}{}

Person::~Person(){
    delete[] wohnort;
    delete[] geburtsort;
}

void Person::setAlter(int x){
    this->alter = x;
}

const std::string Person::getName(){
    return this->name;
}

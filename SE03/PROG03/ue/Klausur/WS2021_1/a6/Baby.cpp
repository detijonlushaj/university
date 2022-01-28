#include "Ort.h"
#include "Person.h"
#include "Baby.h"
#include <stdexcept>
#include <string>

Baby::Baby(Ort* geb, Ort* wohn, std::string name):Person{geb,wohn,0,name}{}

Baby::~Baby(){
    Person::~Person();
}

void Baby::setAlter(int x) throw(std::invalid_argument){
    if( x != 0) throw std::invalid_argument("throwing ...");
}

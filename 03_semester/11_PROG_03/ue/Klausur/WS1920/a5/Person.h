#include "Ort.h"
#include <string>

#ifndef PERSON
#define PERSON

class Person{
    public: 
    Person(Ort* geb, Ort* wohn, int alter, std::string name);
    virtual ~Person();
    virtual void setAlter(int x);
    const std::string getName();

    private:
    const Ort* wohnort;
    const Ort* geburtsort;
    int alter;
    std::string name;

};


#endif
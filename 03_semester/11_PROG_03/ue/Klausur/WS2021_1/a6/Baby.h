#include "Ort.h"
#include "Person.h"
#include <string>
#include <stdexcept>


#ifndef BABY
#define BABY
class Baby: public Person{
public:
    Baby(Ort* geb, Ort* wohn, std::string name);
    virtual ~Baby();
    virtual void setAlter(int) throw(std::invalid_argument) override;

};


#endif

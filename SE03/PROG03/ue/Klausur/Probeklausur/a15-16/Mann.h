#include "Person.h"
#ifndef MANN
#define MANN

class Mann : public Person {
    public:
    Mann();
    virtual std::string anrede();
};
#endif

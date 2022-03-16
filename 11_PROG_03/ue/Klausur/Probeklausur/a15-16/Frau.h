#include "Person.h"
#ifndef FRAU
#define FRAU

class Frau : public Person {
    public:
    Frau();
    virtual std::string anrede() override;
};
#endif

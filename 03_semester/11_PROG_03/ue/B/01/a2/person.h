#include <string>
#ifndef PERSON_H
#define PERSON_H
class Person {
public:
    Person();
    Person(std::string name, int geburtsjahr);
    void print()const;

private:
    std::string name;
    int geburtsjahr;
};
#endif

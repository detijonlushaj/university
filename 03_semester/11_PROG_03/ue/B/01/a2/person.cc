#include <iostream>
#include <string>
#include "person.h"

Person::Person() {
    this->name = "";        //this zeiger deshalb -> 
    this->geburtsjahr = 0;
}

// Person::Person(std::string name, int geburtsjahr){
//     this->name = name;
//     this->geburtsjahr = geburtsjahr;
// }

Person::Person(std::string name, int geburtsjahr): name{name}, geburtsjahr{geburtsjahr}{ }

void Person::print()const{
    std::cout << this->name << " ist " << this->geburtsjahr << " geboren" << std::endl;
}

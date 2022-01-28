#include "Person.h"
#include "Mann.h"
#include "Frau.h"
#include <string>
#include <iostream>

using namespace std;

int main() {     
    Mann m;     
    std::cout << m.anrede() << std::endl;
    // Frau f;     
    // std::cout << f.anrede() << std::endl;       
    Person p;     
    std::cout << p.anrede() << std::endl;     

    //afg 16
    Person& p2 = m;     
    cout << p2.anrede() << endl; 
    return 0; 
}

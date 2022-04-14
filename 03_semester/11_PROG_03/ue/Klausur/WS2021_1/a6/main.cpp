#include <iostream>
#include "Ort.h"
#include "Person.h"
#include "Baby.h"

using namespace std;

int main(void)
{
    Ort hannover{"Hannover", 10, 10};
    Ort hamburg{"Hamburg", 10, 10};
    Person p = {&hannover, &hamburg, 10, "John doe"};
    Baby b = {&hamburg, &hannover, "Ann-Christin"};
    p.setAlter(26);
    b.setAlter(3); // soll fehler werfen
    cout << b.getName() << endl;
    return 0;
}

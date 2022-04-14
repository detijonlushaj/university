#include "person.h"
#define SIZE 2

int main(void) {
    Person arr[SIZE];
    arr[0] = Person("Schehat", 2000);
    arr[1] = Person("Deti", 1999);

    for (const auto &i : arr){
        i.print();
    }
    return 0;
}

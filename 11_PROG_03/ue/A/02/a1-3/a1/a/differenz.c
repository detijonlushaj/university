#include "input.h"

int differenz(void) {
    int a, b;

    a = get_input("Minuend: ");
    b = get_input("Subtrahend: ");

    return a - b;
}
#include "input.h"

int summe(void) {
    int a, b;

    a = get_input("Erster Summand: ");
    b = get_input("Zweiter Summand: ");

    return a + b;
}
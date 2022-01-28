#include <iostream>
#include "CartItem.h"
#include "ShoppingCart.h"

int main(void) {
    ShoppingCart sc;
    sc.add(CartItem{"Hundefutter", 6, 3.20});
    sc.add(CartItem{"Kekse", 4, 1.59});
    sc.add(CartItem{"Milch", 1, 0.69});
    sc.add(CartItem{"Erdbeermarmelade ", 3, 2.19});
    //sc.add(sc.getItem(2));

    std::cout << sc.toString();
}

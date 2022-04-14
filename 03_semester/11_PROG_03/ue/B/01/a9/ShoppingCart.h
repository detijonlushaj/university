#include "CartItem.h"
#include <vector>

//ShoppingCart.h
#ifndef ShoppingCart_H
#define ShoppingCart_H
class ShoppingCart{
public:
    ShoppingCart();
    void add(const CartItem &item);
    double getTotalCost();
    int getNumberOfItems();
    CartItem &getItem(int i);
    std::string toString();
    //----------------
    int* getItemIds();
    //----------------

private:
    std::vector<CartItem> items;
};
#endif

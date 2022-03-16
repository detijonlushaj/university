#include "ShoppingCart.h"
#include <vector>
#include <sstream>
#include <iomanip>

ShoppingCart::ShoppingCart(){
    std::vector<CartItem> items;
}
void ShoppingCart::add(const CartItem &item){
    this->items.push_back(item);
}

double ShoppingCart::getTotalCost(){
    double cost = 0;
    for( auto &elem : items){
        cost += elem.getCost();
    }
    return cost;
}

int ShoppingCart::getNumberOfItems(){
    return items.size();
}

CartItem &ShoppingCart::getItem(int i){
    return items.at(i);
}

std::string ShoppingCart::toString(){
    std::ostringstream stream;

    for( auto elem : items){
        stream << elem.toString();
        stream << "\n";
    }
    stream << "\n";
    stream << "Summe:";

    // 47 total length of toString from CartItem
    stream << std::setw(47 - 6);
    stream << std::right;
    stream.precision(2);
    stream << std::fixed;
    stream << getTotalCost();

    return stream.str();
}

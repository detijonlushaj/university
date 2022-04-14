#include <string>
#include <iomanip>
#include <sstream>
#include "CartItem.h"

//--------------------
int CartItem::lastid {1};

int CartItem::getitemId(){
    return this->itemID; 
}
//--------------------


CartItem::CartItem(const std::string &name, int number, double p) :itemID{++lastid}, name{name}, number{number}, price{p}  {}

//----------------
CartItem::CartItem(const CartItem& old ) :itemID{++lastid}, name{old.name}, number{old.number}, price{old.price} {}
//-----------------

double CartItem::getCost(){ return number*price; }

double CartItem::getPrice(){ return price; }
void CartItem::setPrice(double price){ this->price = price; }

int CartItem::getNumber(){ return number; }
void CartItem::setNumber(int num){ this->number = num; }

const std::string &CartItem::getName(){ return this->name; }
void CartItem::setName(const std::string &name){ this->name = name; }

std::string CartItem::toString(){
    std::ostringstream stream;
    stream << std::setw(2);
    stream << std::left;
    stream << std::to_string(number);
    stream << " x ";                        
    stream << std::setw(30);
    stream << std::left;
    stream << name;
    stream << std::setw(6);
    stream << std::left;
    stream.precision(2);
    stream << std::fixed;
    stream << price;
    stream << std::setw(6);
    stream << std::right;
    stream << getCost();
    return stream.str();
}

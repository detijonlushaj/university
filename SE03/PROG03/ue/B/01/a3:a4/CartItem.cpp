#include <string>
#include <iomanip>
#include <sstream>
#include "CartItem.h"

// CartItem::CartItem(const std::string &name, int number, double price) {
//     this->name = name;
//     this->number = number;
//     this->price = price;
// }
CartItem::CartItem(const std::string &name, int number, double price) :name{name}, number{number}, price{price} {}

double CartItem::getCost(){
    return number*price;
}

double CartItem::getPrice(){
    return price;
}
void CartItem::setPrice(double price){
    this->price = price;
}

int CartItem::getNumber(){
    return number;
}
void CartItem::setNumber(int num){
    this->number = num;
}

const std::string &CartItem::getName(){
    return this->name;
}
void CartItem::setName(const std::string &name){
    this->name = name;
}

std::string CartItem::toString(){
    std::ostringstream stream;
    stream << std::setw(2);                 //set witdh auf 2 
    stream << std::left;                    //nach links gerueckt
    stream << std::to_string(number);       //number

    stream << " x ";                        

    stream << std::setw(30);
    stream << std::left;
    stream << name;

    stream << std::setw(6);
    stream << std::left;
    stream.precision(2);                    //nachkomma stellen
    stream << std::fixed;                   //fixed  gilt fuer alles danach
    stream << price;

    stream << std::setw(6);
    stream << std::right;
    stream << getCost();
    
    return stream.str();                    //stream string bilden und return
}

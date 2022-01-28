#include <string>

#ifndef CARTITEM_H
#define CARTITEM_H
class CartItem {
public:
    CartItem(const std::string &name, int number, double price);
    double getCost();
    const std::string &getName();   //string objekt referenz //const da man nicht aendern darf
    int getNumber();
    double getPrice();
    void setName(const std::string &name);
    void setNumber(int number);
    void setPrice(double price);
    std::string toString();

private:
    std::string name;
    int number;
    double price;
};
#endif

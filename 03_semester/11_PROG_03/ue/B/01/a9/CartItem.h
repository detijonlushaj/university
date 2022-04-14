#include <string>

#ifndef CARTITEM_H
#define CARTITEM_H
class CartItem {
public:
    CartItem(const std::string &name, int number, double price);
    //--------
    CartItem(const CartItem& old);
    //--------

    double getCost();
    const std::string &getName(); 
    int getNumber();
    double getPrice();
    void setName(const std::string &name);
    void setNumber(int number);
    void setPrice(double price);
    std::string toString();

    //--------------------
    int getitemId();
    //--------------------

private:
    //--------
    static int lastid;
    const int itemID;
    //--------
    std::string name;
    int number;
    double price;
};
#endif

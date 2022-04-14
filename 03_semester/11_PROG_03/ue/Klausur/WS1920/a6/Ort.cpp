#include "Ort.h"
#include <string>

Ort::Ort(std::string name, int x, int y): name{name}, laenge{x},breite{y}{}


Ort::Ort(const Ort& copy){
    this->laenge = copy.laenge;
    this->breite = copy.breite;
    this->name = copy.name;
}
Ort& Ort::operator = (const Ort& copy){
    this->laenge = copy.laenge;
    this->breite = copy.breite;
    this->name = copy.name;
    return *this;
}
bool Ort::operator == (const Ort& other){
    if( (this->laenge == other.laenge) && (this->breite == other.breite) && (this->name.length() == other.name.length()) ){
        for (int i = 0; i < other.name.length(); i++){
            if(this->name.at(i) != other.name.at(i)){
                return false;
            }
        }
        return true;
    } else {
        return false;
    }
}
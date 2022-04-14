// Ort-lzz.cpp
//

#include "Ort-lzz.h"
#define LZZ_INLINE inline
using namespace std;
void Ort::initName (char const * pname)
                                   {
    name= (char*)malloc(strlen(pname)+1);  
    // spaeter: new char[strlen(pname)+1] bzw. std::string statt char[] und ...
    strcpy(name, pname);  // ... dann hier Copy-Konstruktor von string benutzen
  }
double Ort::getBreite ()
                     { return breite; }
double Ort::getLaenge ()
                     { return laenge; }
double Ort::getHoehe ()
                    { return hoehe; }
char const * Ort::getName ()
                        { return name; }
Ort::Ort (double breite, double laenge, double hoehe, char const * name)
                                                                    { 
    this->breite= breite; this->laenge= laenge; this->hoehe= hoehe;
    initName(name); 
  }
Ort::Ort (double breite, double laenge, char const * name)
  { 
    this->breite= breite; this->laenge= laenge; this->hoehe= 0.0;
    initName(name); 
  }
Ort::Ort (Ort const & o)
                    { 
    this->breite= o.breite; this->laenge= o.laenge; this->hoehe= o.hoehe;
    initName(o.name); 
  }
Ort::~ Ort ()
         { 
    free(name);  name = nullptr;
  }
void Ort::print ()
               {
    cout << name << " (" << breite << "°B, " << laenge << "°L, " << hoehe << " m ü. NN)" << endl;
  }
int main () {
  Ort hannover { 52.3667, 9.71667, 55.0, "Hannover"};
  Ort hannover2 {hannover};
  Ort rio {-22.9, -43.23333, 32.0, "Rio de Janeiro"};  
  hannover.print();
  hannover2.print();
  rio.print();
}
#undef LZZ_INLINE

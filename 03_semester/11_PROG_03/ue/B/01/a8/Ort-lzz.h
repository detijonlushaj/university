// Ort-lzz.h
//

#ifndef LZZ_Ort_lzz_h
#define LZZ_Ort_lzz_h
#include <cstring>
#include <cstdlib>
#include <iostream>
#define LZZ_INLINE inline
class Ort
{
private:
  double breite;
  double laenge;
  double hoehe;
  char * name;
  void initName (char const * pname);
public:
  double getBreite ();
  double getLaenge ();
  double getHoehe ();
  char const * getName ();
  Ort (double breite, double laenge, double hoehe, char const * name);
  Ort (double breite, double laenge, char const * name);
  Ort (Ort const & o);
  ~ Ort ();
  void print ();
};
int main ();
#undef LZZ_INLINE
#endif

#include <iostream>
#include <stdexcept>
using namespace std;

const int N = 2;

class Vektor {

  friend ostream& operator << (ostream& out, const Vektor& v);
  friend istream& operator >> (istream& in, Vektor& v);

  // friend Vektor operator + (const Vektor & v1, const Vektor &v2);
  friend bool operator == (const double d[], const Vektor& c); 

  private:
    double* elems;

  public:

    // Standard-Konstruktor
    Vektor() {
      elems = new double[N];
    }

    // Weiterer Konstruktor
    Vektor(const double values[]) {
      elems = new double[N];
      for (int i = 0; i < N; ++i)
        elems[i] = values[i];
    }

    // Copy-Konstruktor
    Vektor(const Vektor& v) {
      elems = nullptr;  // Undefinierten Wert überschreiben, damit das 
          // delete[] elems in operator= nicht abstuerzt 
          // (delete nullptr oder delete[] nullptr hat keine Wirkung)
      *this = v;  // Zuweisungsoperator nutzen vermeidet redundanten Code
    }

    // Zuweisungsoperatoren

    Vektor& operator = (const Vektor& v) {
      if (this ==  &v) return *this;   // Nichts zu tun
      delete[] elems;
      elems = new double[N];
      for (int i = 0; i < N; ++i)
        elems[i] = v.elems[i];
      return *this;
    }

    Vektor& operator += (const Vektor& v) {
       for (int i = 0; i < N; ++i)
         elems[i] += v.elems[i];
       return *this; 
    }

    Vektor& operator += (const double d[]) {
      Vektor v {d};
      return *this += v;  // operator+=(const Vektor&) nutzen vermeidet Code-Redundanz
    }

    // Vergleichsoperatoren

    bool operator == (const Vektor& v) const {
      return *this == v.elems;  // Überladenen operator== aufrufen vermeidet Redundanz
    }

    bool operator == (const double d[]) const {
      for (int i = 0; i < N; ++i)
        if (elems[i] != d[i])
	  return false;
      return true;
    }

    // Destruktor
    ~Vektor() {
      delete[] elems;
    }

    // Weitere Operatoren

    Vektor operator + (const Vektor& v) const {
      Vektor result {*this};  // Copy-Konstruktor
       result += v;  // operator+= nutzen vermeidet Code-Redundanz
       return result;
    }

    Vektor operator * (const double f) const {
      Vektor result {};
      for (int i = 0; i < N; ++i)
        result.elems[i] = this->elems[i]*f;
       return result;
    }

    double& operator [] (int index) const {
      if (index < 0 || index >= N)
        throw invalid_argument("Indexfehler");
     return elems[index];
    }


  // Die folgenden Methoden sollen nur zeigen, wie umstaendlich zusammengesetzte
  // Ausdruecke in main() ohne Operatoren werden:

    Vektor plus(const Vektor& v) const {
      Vektor result {};
       for (int i = 0; i < N; ++i)
         result.elems[i] = this->elems[i] + v.elems[i];
       return result;
    }

    Vektor minus(const Vektor& v) const {
      Vektor result {};
       for (int i = 0; i < N; ++i)
         result.elems[i] = this->elems[i] - v.elems[i];
       return result;
    }

    Vektor prod(const double f) const {
      Vektor result {};
      for (int i = 0; i < N; ++i)
        result.elems[i] = this->elems[i]*f;
       return result;
    }

    double prod(const Vektor& v) const {
      double sprod = 0;
      for (int i = 0; i < N; ++i)
	sprod += elems[i] * v.elems[i];
      return sprod;
    }

};

// Globale Varianten:

/* Alternative Realisierung von operator+ als globale Funktion
 * Hier auskommentiert, da sonst der +-Aufruf in main() nicht eindeutig waere

Vektor operator + (const Vektor& v1, const Vektor& v2) {
  Vektor result {};
   for (int i = 0; i < N; ++i)
     result.elems[i] = v1.elems[i] + v2.elems[i];
   return result;
}
*/

bool operator == (const double d[], const Vektor& v) {
  return v == d; // v.operator==(double[]) aufrufen
}

ostream& operator << (ostream& out, const Vektor& v) {
   out << "(" << v.elems[0]; 
   for (int i = 1; i < N; ++i) {
     out << ", " << v.elems[i]; 
   }
   out << ")";
   return out;
}

//Version für beliebiges N:
istream& operator >> (istream& in, Vektor& v) {
  double values[N];
  for (int i = 0; i < N; ++i)
    in >> values[i]; 
  v = Vektor(values);
  return in;
}

int main(void) {
  double values1[N] = { 1, 1 };
  double values2[N] = { 2, 2 };
  Vektor v1 {values1};
  Vektor v2 {values2};
  Vektor r { (v1 + v2)*1.5 }; // Umständlicher wäre v1.plus(v2).prod(1.5);
  cout << "((1,1) + (2, 2)) * 1.5 = " << r << endl; 
  cout << "Geben Sie zwei double-Zahlen ein:" << endl;
  Vektor v;
  cin >> v;
  cout << "Der eingegebene Vektor war " << v << endl;

  // Hier fehlen noch Tests für Additionen, Zuweisungen und Vergleiche

  return 0;
}

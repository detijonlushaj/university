#include <iostream>
using namespace std;

class Kreditgeber {
public:
  Kreditgeber(const string& pName) 
    : name {pName}, vergebenesKreditVolumen {0} { }
  void auszahlen(const int betrag) {
    cout << name << " zahlt Kredit über " << betrag << 
      " EUR aus." << endl;
    vergebenesKreditVolumen += betrag;
  }
  void zurueckzahlen(int betrag) {
    cout << name << " bekommt Kredit über " << betrag << 
      " EUR zurückgezahlt." << endl;
    vergebenesKreditVolumen -= betrag;
  }
private:
  const string name;
  int vergebenesKreditVolumen;
};


class Kredit {
public:
  Kredit(Kreditgeber& kreditgeber, const int betrag);
  ~Kredit();
private:
  Kreditgeber& kreditgeber;
  const int betrag;
};

Kredit::Kredit(Kreditgeber& kreditgeber, const int betrag) 
  : kreditgeber {kreditgeber}, betrag {betrag}     {
    kreditgeber.auszahlen(betrag);
}

Kredit::~Kredit() {
  kreditgeber.zurueckzahlen(betrag);
}


void nutze(Kredit kredit) {
  cout << "Kreditnehmer nutzt den Kredit." << endl;
}

int main(void) {
  Kreditgeber sparkasseHannover {"Sparkasse Hannover"};
  Kredit meinKredit {sparkasseHannover, 5000}; // Hole Kredit
  nutze(meinKredit);                           // Nutze Kredit
  // Rueckzahlung von meinKredit automatisch durch Destruktor :-)
  return 0;
}

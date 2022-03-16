// Grobject.h

#ifndef GROBJECT_H
#define GROBJECT_H
#include "CPos.h"

// Abstrakte Klasse für positionierbare farbige grafische Objekte
// Subklassen implementieren die draw-Methode.
class Grobject {
public:
  Grobject(int c, int r, Color col);
  virtual ~Grobject();
  virtual void draw() const=0; // Setzt Zeichenfarbe und positioniert Cursor. Soll von Subklassen überschrieben werden.
  // private:  // auskommentiert, damit Zugriff in E() (in main.c) moeglich
  CPos cPos;
};

#endif

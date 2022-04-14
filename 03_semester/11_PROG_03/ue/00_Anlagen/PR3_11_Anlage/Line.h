// Line.h

#ifndef LINE_H
#define LINE_H
#include "Grobject.h"

// positionierbare, farbige horizontale Linie
class Line : public Grobject {
public:
    int len;
   Line(int c, int r, Color col, int len);
  virtual ~Line();
 virtual void draw() const override; 
};

#endif

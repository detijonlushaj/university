// Rect.h

#ifndef RECT_H
#define RECT_H
#include "Grobject.h"

// positionierbares, farbiges Rechteck
class Rect : public Grobject {
public:
	int w, h;
	Rect(int c, int r, Color col, int w, int h);
  virtual ~Rect();
  void draw() const override; 
};

#endif

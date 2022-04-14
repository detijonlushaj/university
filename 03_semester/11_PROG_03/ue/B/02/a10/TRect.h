// TRect.h

#ifndef TRECT_H
#define TRECT_H
#include "Text.h"
#include "Rect.h"

class TRect : public Rect, public Text {
public:
  TRect(int c, int r, Color col, int w, int h, string text);
  virtual ~TRect();
  virtual void draw() const; 
};

#endif

// Text.h

#ifndef TEXT_H
#define TEXT_H
#include "Grobject.h"

#include <string>
using namespace std;

// positionierbarer, farbiger Text
class Text : public Grobject {
public:
  string text;
  Text(int c, int r, Color col, string text);
  virtual ~Text();
  void draw() const override; 
};

#endif

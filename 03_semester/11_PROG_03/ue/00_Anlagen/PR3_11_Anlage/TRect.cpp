// TRect.cpp
#include "TRect.h"

#include <iostream>
using namespace std;

TRect::TRect(int c, int r, Color col, int w, int h, string text) : 
   /* Falls Grobject eine virtuelle Basisklasse von Rect und von Text ist:
      Grobject(c, r, color), */
  Rect(c, r, col, w, h), Text(c, r, col, text) {
}
	
TRect::~TRect() { }

void TRect::draw() const {
	Rect::draw();
	Text::draw();
}

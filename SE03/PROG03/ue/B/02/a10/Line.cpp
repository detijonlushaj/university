// Line.cpp
#include "Line.h"

#include <iostream>
using namespace std;

Line::Line(int c, int r, Color col, int pLen) : 
        Grobject {c, r, col}, 
        len(pLen) {
}
	
void Line::draw() const {
  Grobject::draw();
  for (int i = 0; i < len ; ++i) {
    cout << "-";
  }
}

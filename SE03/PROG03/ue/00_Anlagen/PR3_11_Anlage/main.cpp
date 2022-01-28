// main.cpp

#include "Pos.h"
#include "CPos.h"
#include "Rect.h"
#include "Line.h"
#include "Text.h"
#include "TRect.h"
#include <iostream>
using namespace std;


void A() {
  Pos a {};
  a.prep();
  cout << "("<<a.c<<","<<a.r<<")";
  
  Pos b {20,12};
  b.prep();
  cout << "("<<b.c<<","<<b.r<<")";
}

void B() {
  CPos a {};
  a.prep();
  cout << "("<<a.Pos::c<<","<<a.r<<")-"<<a.c;
  
  CPos b {20, 12, GREEN};
  b.prep();
  cout << "("<<b.Pos::c<<","<<b.r<<")-"<<b.c;
}


void C() {
  Rect a {10, 5, BLUE, 20, 4};
  Rect b {20, 7, YELLOW, 5, 10};
  a.draw();
  b.draw();
}

void D() {
  Rect b {20, 7, YELLOW, 5, 10};
  b.draw();
  Text tb {20, 7, YELLOW, "Text"};
  tb.draw();
}


void E() {
  TRect tr {20, 7, YELLOW, 5,10, "Text"};
  tr.Rect::cPos.c = GREEN; // faerbt nur Rect, nicht Text (ausser wenn CPos eine virtuelle Basisklasse von Rect und von Text ist)
  tr.draw();
}

void F() {
  Line line {5, 10, RED, 10};
  line.draw();
}

int main(void) {

  cout << "\033[2J"; // clear screen
  
  A();
  B();
  C();
  D();
  E();
  F();
  
  cout << "\033[40;80f"; // Cursor nach unten rechts
  return 0;
}

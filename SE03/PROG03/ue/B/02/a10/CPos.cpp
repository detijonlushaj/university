// CPos.cpp
#include "CPos.h"
#include <iostream>
using namespace std;

CPos::CPos() : c(WHITE) { }
  
CPos::CPos(int c, int r, Color col) : Pos {c, r}, c {col} { }
  
CPos::~CPos() { }

void CPos::prep() const {
  Pos::prep();
  switch (c) {
    case BLACK   : cout << "\033[22;30m"; break;
    case WHITE   : cout << "\033[01;37m"; break;
    case RED     : cout << "\033[01;31m"; break;
    case GREEN   : cout << "\033[01;32m"; break;
    case BLUE    : cout << "\033[01;34m"; break;
    case YELLOW  : cout << "\033[01;33m"; break;
  }
}

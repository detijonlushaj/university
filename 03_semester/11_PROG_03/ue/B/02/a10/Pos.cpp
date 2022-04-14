// Pos.cpp
#include "Pos.h"
#include <iostream>
using namespace std;

Pos::Pos(): c(0), r(0) { }
Pos::Pos(int pc, int pr) : c {pc}, r {pr} { }
Pos::~Pos() { }

void Pos::prep() const {
	cout << "\033["<<r<<";"<<c<<"H";
}

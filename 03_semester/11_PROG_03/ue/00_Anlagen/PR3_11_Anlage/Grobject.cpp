// Grobject.cpp
#include "Grobject.h"

Grobject::Grobject(int c, int r, Color col) : cPos {c, r, col} { }
	
Grobject::~Grobject() { }

void Grobject::draw() const {
	cPos.prep();
}

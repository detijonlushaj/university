// Text.cpp
#include "Text.h"

#include <iostream>
using namespace std;

Text::Text(int c, int r, Color col, string text) : Grobject {c, r, col}, text {text} { }
	
Text::~Text() { }

void Text::draw() const {
	Grobject::draw();
	cout << text;
}

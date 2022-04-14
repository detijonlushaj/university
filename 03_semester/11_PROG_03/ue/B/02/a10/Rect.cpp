// Rect.cpp
#include "Rect.h"

#include <iostream>
using namespace std;

Rect::Rect(int c, int r, Color col, int pw, int ph) : Grobject {c, r, col}, w {pw}, h {ph} {
}
	
Rect::~Rect() { }

void Rect::draw() const {
  Grobject::draw();
  cout << "+";
  for (int i = 1; i < w - 1; i++) {
    cout << "-";
  }
  cout << "+";
  cout << "\033["<<w<<"D"; // w Spalten zurück
  cout << "\033[1B"; // Eine Zeile runter
  for (int j=1; j<h-1; j++) {
  	cout << "|";
		for (int i = 1; i < w - 1; i++) {
			cout << " ";
		}
  	cout << "|";
		cout << "\033["<<w<<"D"; // w Spalten zurück
	  cout << "\033[1B"; // Eine Zeile runter
	}
	cout << "+";
	for (int i=1; i<w-1; i++) {
		cout << "-";
	}
	cout << "+";
}

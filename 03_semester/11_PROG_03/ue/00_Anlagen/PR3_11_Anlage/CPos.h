// CPos.h

#ifndef CPOS_H
#define CPOS_H
#include "Pos.h"
#include "Color.h"

/* CPos ist eine farbige Markierung auf dem Bildschirm */
class CPos : public Pos {
public:
  Color c;
  CPos();
  CPos(int c, int r, Color col);
  ~CPos();
  void prep() const; // positioniert Cursor und setzt Zeichenfarbe
};

#endif

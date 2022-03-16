// Pos.h
#ifndef POS_H
#define POS_H

/* Pos ist eine Position auf dem Bildschirm */
class Pos{
public:
  int c, r; // column / row
  Pos();
  Pos(int pc, int pr);
  virtual ~Pos();
  void prep() const; // positioniert den Cursor
};
#endif

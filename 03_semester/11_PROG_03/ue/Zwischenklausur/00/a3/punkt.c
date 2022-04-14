#include "punkt.h"

struct punkt erzeuge(int x, int y){
    struct punkt px = { x ,y };
    return px;
}

void spiegeln(struct punkt * p){
    int temp = p->x;
    p->x = p->y;
    p->y = temp;
}

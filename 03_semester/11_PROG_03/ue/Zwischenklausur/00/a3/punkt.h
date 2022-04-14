#ifndef SH
#define SH
struct punkt {
    int x;
    int y;
} punkt;
#endif

extern struct punkt erzeuge(int x, int y);
extern void spiegeln(struct punkt * x);

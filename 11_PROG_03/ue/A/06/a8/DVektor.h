#ifndef SH
#define SH
struct DVektor{
    double a;
    double b;
};
#endif

struct DVektor_s;
typedef struct DVektor_s* DVektor;
extern DVektor create(double data[], int nElems);
extern DVektor copy(DVektor original);
extern void delete(DVektor v);
extern int add(DVektor destination, DVektor source); 
extern void process(DVektor v, void (*f)(double* elemPtr));

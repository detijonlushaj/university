
struct Vektor_s;
typedef struct Vektor_s* Vektor;
extern Vektor create(char data[], int nElems, int elemSize); 
extern Vektor copy(Vektor original);
extern void delete(Vektor v);
extern void process(Vektor v, void (*f)(char* elemPtr));

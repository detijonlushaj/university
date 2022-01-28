#include "Vektor.h" 
#include <stdlib.h> 
#include <string.h>
struct Vektor_s { 
    int nElems;
    int elemSize; 
    char* data;
};
Vektor create(char data[], int nElems, int elemSize) { 
    Vektor this = (Vektor)malloc(sizeof(struct Vektor_s)); 
    this->nElems = nElems;
    this->elemSize = elemSize;
    this->data = (char*)malloc(nElems * elemSize); 
    memcpy(this->data, data, nElems * elemSize); 
    return this;
}
Vektor copy(Vektor original) {
    return create(original->data, original->nElems, original->elemSize);
}
void delete(Vektor v) {
    free(v->data);
    v->data = NULL; /* Just to make sure */ 
    free(v);
}
void process(Vektor v, void (*f)(char* elemPtr, int elemSize)) { 
    int i;
    for (i = 0; i < v->nElems; ++i)
        (*f)(&v->data[i * v->elemSize], v->elemSize);
}
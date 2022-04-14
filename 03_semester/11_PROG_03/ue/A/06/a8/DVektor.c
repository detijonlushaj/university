#include "DVektor.h"
#include <stdlib.h>
struct DVektor_s { 
    int nElems; 
    double* data;
};

DVektor create(double data[], int nElems) { 
    int i;
    DVektor this = (DVektor)malloc(sizeof(struct DVektor_s)); 
    this->nElems = nElems;
    this->data = (double*)malloc(nElems * sizeof(double)); 
    for (i = 0; i < nElems; ++i)
        this->data[i] = data[i]; 
    return this;
}
DVektor copy(DVektor original) {
    return create(original->data, original->nElems);
}
void delete(DVektor v) {
    free(v->data);
    v->data = NULL; /* Just to make sure */ 
    free(v);
}
int add(DVektor destination, DVektor source) { 
    int i;
    if (destination->nElems != source->nElems) return 0;
    for (i = 0; i < destination->nElems; ++i) 
        destination->data[i] += source->data[i];
    return 1; 
}
void process(DVektor v, void (*f)(double* elemPtr)) { 
    int i;
    for (i = 0; i < v->nElems; ++i) (*f)(&v->data[i]);
}
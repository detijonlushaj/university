#include "punkt.h"
#include <stdio.h>

int main(){
    struct punkt p = erzeuge(5, 2);    
    spiegeln(&p);
    printf("(%d,%d)", p.x, p.y); // soll (-5,2) sein
    return 0;
}

/**
schreibe ein lauffähiges program das folgenden code korrekt ausführt! 
erzeuge soll eine *Wertübergabe* machen Spiegeln soll "via pointer" funktionieren

spiegelung.c

```
int main(){
    ________ = erzeuge(5, 2);    
    spiegeln(_______);
    printf("(%d,%d)", p.x, p.y); // soll (-5,2) sein
    return 0;
}
```

Schreibe punkt.h und punkt.c

* punkt.h
* punkt.c
 */
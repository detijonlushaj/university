#include <stdio.h>

int char2int(char c) {
    return c - '0';
}
void foo(char *p, int *querSumme) {
    *querSumme += char2int(*p);
}

int main(void) {
    char zahl[] = "1234";
    int querSumme = 0;
    char *cursor = zahl;
    while(*cursor != '\0'){
        foo(cursor, &querSumme);
        cursor++;
    }
    printf("%d", querSumme);
}

/**
## 2 foo Programmieren - 9p

Quersumme char2toInt

schhreibe eine funktion foo die die quersumme ausrechnet

```
int char2int(char c) {
    return c - '0';
}

int main(void) {
    char zahl[] = "3254712874217846";
    int querSumme = 0;
    char *cursor = zahl;
    while(cursor != '\0'){
        foo(____*cursor_____, ____&quersumme___);
    }
}

void foo(char *cursor, int *zahl ) {
    *zahl += char2int(*cursor);
    cursor++;
}
```
 */

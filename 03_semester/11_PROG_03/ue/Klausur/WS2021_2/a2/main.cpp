#include <stdio.h>

int char2int(char c) {
    return c - '0';
}

void foo(int* q, char ** c){
    *q += char2int(**c);
    (*c)++;
}

int main(void) {
    char string[] = "579";
    int quersumme = 0;
    char *cursor = string;

    while (*cursor != '\0')
    {
        foo(&quersumme, &cursor);
    }
    printf("%d", quersumme);
}
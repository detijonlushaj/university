#include <stdio.h>

char* find(char s[], char c){
    int cnt =0;
    char* p = NULL;
    while (s[cnt] != '\0') {
        if ( s[cnt] == c ) {
            p = &c;
        }
        ++cnt;
    }
    return p;
}

int main(void) {
    if(find("ddd",'d')) {
        printf("true");
    }
}
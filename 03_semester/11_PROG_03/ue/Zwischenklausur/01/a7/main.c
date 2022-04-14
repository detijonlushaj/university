#include <stdio.h>
#include <string.h>

void findMaxString(char* strings[], char **maxPtr){
    //char** s = strings[0];
    *maxPtr = strings[0];
    
    for (int i = 0; strings[i] != NULL ; i++) {
        if( strcmp(strings[i],*maxPtr) > 0 ){
            *maxPtr = strings[i];
        }
    }
    
    // while ( *s != NULL) {
    //     if(strcmp(*s,*maxPtr) > 0) {
    //         *maxPtr = *s;
    //     }
    //     s++;
    // }
}


int main(void){
    char* strings[] = {"abc", "rst", "def", "rrr", NULL};
    char* max;
    findMaxString(strings, &max);
    printf("Der größte String ist %s\n", max);  // druckt "... rst"

    printf("%s\n",strings[1]);
    printf("%s\n",strings[3]);
    printf("%s\n",strings[0]);

    return 0;
}


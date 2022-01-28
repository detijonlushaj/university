#include <string.h>
#include <stdio.h>

void mystrcat(char s1[], char s2[]){
    int index1 = 0;
    while ( s1[index1] != '\0'  ) {
        index1++;
    }

    int index2 = 0;
    while ( s1[index2] != '\0') {
        index2++;
    }

    for(int i =0; i< index2 ; i++) {
        s1[index1 + i] = s2[i];
    }

    s1[index1+index2] =  '\0';




}

// char* mystrcat(char s1[], char s2[]) { 
//     int sourceOffset = 0;
//     int destOffset = strlen(s1);
//     while (s2[sourceOffset] != '\0')
//         s1[destOffset++] = s2[sourceOffset++]; s1[destOffset] = '\0';
//     return s1;
// }


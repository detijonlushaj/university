//Was ist der Rückgabewert der folgenden Funktion? Erklären Sie, wie er zustande kommt.
#include <stdio.h>
char* foo(char* s1, char* s2) {
    char *start, *left, *right;
    for (start = s1; *start != '\0'; ++start) {                     //erste char* durchlaufen
        for (left = start, right = s2;                              //subarray von i bis 
            *left != '\0' && *right != '\0' && *left == *right; 
            ++left, ++right)                                        //wenn rechts und links ungleich null element sind und left char = right char 
                                                                    // dann r++ l++
        ;
        if (*right == '\0')                                         //wenn s2 also ein teilindex vom ersten array ist vom start s1,s2 bis ende s2 dann return s1
            return start; 
    }
    return NULL;
}

int main(void) {
    printf("%s \n",foo("aaab","aaab"));
    return 0;
}
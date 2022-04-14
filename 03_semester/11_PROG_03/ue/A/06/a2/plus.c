#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>


int checkError(char *endptr, char *input) {
    if (strlen(endptr) != 0) {
        printf("Kann '%s' nicht in Zahl umwandeln: Falsches Format\n", input);
        return 1;
    }
    else if (errno != 0) {
        printf("Kann '%s' nicht in Zahl umwandeln: %s\n", input, strerror(errno));
        return 1;
    }
    return 0;
}

int main(int argc, char *argv[]){
    long a1,a2;
    char* endptr = NULL;
    errno = 0;    

    if (argc != 3) {
        printf("Benutzung: %s <zahl> <zahl>", argv[0]);
        return 1;
    }

    a1 = strtol(argv[1], &endptr, 10);                              /* 10 = base = Dezimalsystem */ 
    if (checkError(endptr, argv[1]) == 1) return 1;

    endptr = NULL;      //eig nicht noetig
    a2 = strtol(argv[2], &endptr, 10);
    if (checkError(endptr, argv[2]) == 1) return 1;

    printf("%ld + %ld = %ld", a1,a2,(a1+a2));
    return 0;
}

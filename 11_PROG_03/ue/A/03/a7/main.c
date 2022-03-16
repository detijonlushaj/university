#include <stdio.h>
int main(void) {
    int i;
    int* ip = &i;
    printf("Eingabe: ");
    scanf("%d", ip);
    ip = &i;     /* Hier fehlt Ihr Code */ ; 

    printf("Eingabe war %d\n", *ip ); 
    
    return 0;
}

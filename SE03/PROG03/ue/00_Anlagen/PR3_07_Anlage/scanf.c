#include <stdio.h>
int main(void) {
	char name[41];
	int alter;
	printf("Ihr Alter: ");
	scanf("%d", &alter);
	while (getchar() != '\n') ;
	printf("Ihr Name: ");
	scanf("%40[^\n]", name); /* <= 40 Zeichen bis zum \n lesen */
	printf("%s ist %d Jahre alt\n", name, alter);
	return 0;
}

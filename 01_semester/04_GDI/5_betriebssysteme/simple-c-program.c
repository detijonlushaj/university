/*
 * Ein einfaches C-Programm mit zwei Funktionen, die
 * etwas rechnen und die man prima im Debugger durchgehen kann.
 *
 * simple-c-program.c
 *
 * Stefan Wohlfeil
 *
 * 2018-08-01
 *
 */

#include <stdio.h> /* Standard-IO-Funktionen */


/* C-Programme bestehen im wesentlichen aus Funktionen, die
   sich gegenseitig aufrufen.
   Eine Funktion besteht aus 
   (1) einer Deklaration (Name und formale Parameter) und
   (2) der Implementierung.
*/
int ggtRekursiv ( /* (1) */
	int	a,
	int	b) 
{ /* (2) */

   if ( 0 == b ) {
      return a;
   } else {
      /* erneuter Aufruf der Funktion ggtRekursiv */
      return ggtRekursiv(b, a%b);
   } /* if */
} /* ggtRekursiv */





int ggtIterativ (
	int	a,
	int	b)
{
int	h;

   while ( b != 0 ) {
      h = a%b;
      a = b;
      b = h;
   } /* while */
   return a;
} /* ggtIterativ */

/* Absolutwert einer ganzen Zahl bestimmen und zurueckgeben*/
int myAbs (int a) 
{
  if (a < 0)
    a=a*(-1);
  return a;
}

/* Jedes C-Programm muss eine Funktion mit Namen main enthalten.
   Diese Funktion wird beim Start des Programmes aufgerufen.
*/
int main (
	int argc,
	char *argv[] ) {

int	eingabe1, eingabe2;
int	ggtR, ggtI;

   printf("Berechnung des ggt von zwei Zahlen. Eingabe Zahl 1: ");
   scanf("%d", &eingabe1);
   eingabe1=myAbs(eingabe1); //Absolutwer bestimmen 
   printf("Eingabe Zahl 2: ");
   scanf("%d", &eingabe2);
   eingabe2=myAbs(eingabe2);
   ggtR = ggtRekursiv(eingabe1, eingabe2);
   ggtI = ggtIterativ(eingabe1, eingabe2);

   printf("Der rekursiv berechnete ggt(%d,%d) ist: %d\n",
      eingabe1, eingabe2, ggtR);
   
   printf("Der iterativ berechnete ggt(%d,%d) ist: %d\n",
      eingabe1, eingabe2, ggtI);
} /* main */

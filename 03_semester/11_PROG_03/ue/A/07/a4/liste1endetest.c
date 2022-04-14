/* liste1endetest.c */

#include <stdlib.h>
#include <stdio.h>
#include "liste1ende.h"

int main(void)
{

  struct knoten *kopf = NULL;
  struct knoten *ende = NULL;

  struct knoten *neu4, *neu5, *neu6, *neu7, *such, *entf;

  neu5 = malloc(sizeof(*neu5));
  neu5->wert = 5;
  neu5->next = NULL;

  if (einfuegen_kopf(&kopf, &ende, neu5) != 0)
  {
    printf("Fehler beim einf�gen\n");
    return -1;
  }

  neu6 = malloc(sizeof(*neu6));
  neu6->wert = 6;
  neu6->next = NULL;
  if (einfuegen_nach(neu5, neu6, &ende) != 0)
  {
    printf("Fehler beim einf�gen\n");
    return -1;
  }

  durchlaufen(kopf);
  such = suchen(kopf, 5);
  if (such == NULL || such->wert != 5)
  {
    printf("Fehler: suchen. 5 nicht gefunden\n");
    return -1;
  }

  such = suchen(kopf, 6);
  if (such == NULL || such->wert != 6)
  {
    printf("Fehler: suchen. 6 nicht gefunden\n");
    return -1;
  }

  such = suchen(kopf, 7);
  if (such != NULL)
  {
    printf("Fehler: suchen. 7 gibt es gar nicht\n");
    return -1;
  }

  neu4 = malloc(sizeof(*neu4));
  neu4->wert = 4;
  neu4->next = NULL;
  if (einfuegen_kopf(&kopf, &ende, neu4) != 0)
  {
    printf("Fehler beim einf�gen\n");
    return -1;
  }

  such = suchen(kopf, 4);
  if (such == NULL || such->wert != 4)
  {
    printf("Fehler: suchen. 4 nicht gefunden\n");
    return -1;
  }

  such = suchen(kopf, 6);
  if (such == NULL || such->wert != 6)
  {
    printf("Fehler: suchen. 6 nicht gefunden\n");
    return -1;
  }

  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  neu7 = malloc(sizeof(*neu7));
  neu7->wert = 7;
  neu7->next = NULL;
  if (einfuegen_ende(&kopf, &ende, neu7) != 0)
  {
    printf("Fehler beim einf�gen\n");
    return -1;
  }

  such = suchen(kopf, 4);
  if (such == NULL || such->wert != 4)
  {
    printf("Fehler: suchen. 4 nicht gefunden\n");
    return -1;
  }

  such = suchen(kopf, 6);
  if (such == NULL || such->wert != 6)
  {
    printf("Fehler: suchen. 6 nicht gefunden\n");
    return -1;
  }

  such = suchen(kopf, 7);
  if (such == NULL || such->wert != 7)
  {
    printf("Fehler: suchen. 7 nicht gefunden\n");
    return -1;
  }

  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  entf = entfernen(&kopf, &ende, neu5);
  if (entf == NULL)
  {
    printf("Fehler: entfernen. 5 nicht gefunden\n");
    return -1;
  }

  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  entf = entfernen(&kopf, &ende, neu7);
  if (entf == NULL)
  {
    printf("Fehler: entfernen. 7 nicht gefunden\n");
    return -1;
  }

  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  entf = entfernen_kopf(&kopf, &ende);
  if (entf == NULL)
  {
    printf("Fehler: entfernen. 4 nicht gefunden\n");
    return -1;
  }

  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  entf = entfernen_ende(&kopf, &ende);
  if (entf == NULL)
  {
    printf("Fehler: entfernen. 6 nicht gefunden\n");
    return -1;
  }

  printf("Leerer Durchlauf:");
  durchlaufen(kopf);

  printf("-----------------\nMehr Tests:\n");

  // Test einfuegen_ende auf leerer Liste:
  if (einfuegen_ende(&kopf, &ende, neu7) != 0)
  {
    printf("Fehler beim einf�gen\n");
    return -1;
  }
  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  // Test einfuegen_kopf auf ein-elementiger Liste:
  if (einfuegen_kopf(&kopf, &ende, neu5) != 0)
  {
    printf("Fehler beim einf�gen\n");
    return -1;
  }
  durchlaufen(kopf);
  printf("*ende=%d\n", ende->wert);

  return 0;
}

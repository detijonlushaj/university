#include <stdlib.h>
#include <stdio.h>



struct knoten {
    int wert; /* oder komplexere Daten */
    struct knoten *next;
};


void durchlaufen(struct knoten *kopf) {
    struct knoten *laufzeiger;
    laufzeiger = kopf;
    while (laufzeiger!=NULL) {
        printf("%d ",laufzeiger->wert);
        laufzeiger = laufzeiger->next;
    }
    printf("\n");
}



struct knoten* suchen(struct knoten* kopf, int gesuchter_wert) {
    struct knoten* laufzeiger;
    laufzeiger = kopf;
    while ((laufzeiger!=NULL)&&(laufzeiger->wert!=gesuchter_wert)) {
        laufzeiger = laufzeiger->next;
    }
    return laufzeiger;
}


/* Liefert -1 im Fehlerfall, sonst 0 */
int einfuegen_kopf(struct knoten* *kopfref, struct knoten* einzufueg) {
    if ((einzufueg==NULL)||(kopfref==NULL)) return -1;
    einzufueg->next = *kopfref;
    *kopfref = einzufueg;
    return 0;
}


int einfuegen_nach(struct knoten* nachdiesem, struct knoten* einzufueg) {
    if ((nachdiesem==NULL)||(einzufueg==NULL))  return -1;
    einzufueg->next = nachdiesem->next;
    nachdiesem->next = einzufueg;
    return 0;
}

int einfuegen_ende(struct knoten* *kopfref, struct knoten* einzufueg) {
    struct knoten* ende;
    if ((einzufueg==NULL)||(kopfref==NULL)) return -1;
    if (*kopfref==NULL) {
        einzufueg->next = NULL;
        *kopfref = einzufueg;
    } else {
        ende = *kopfref;
        while (ende->next!=NULL) {
            ende = ende->next;
        }
        einfuegen_nach(ende,einzufueg);
    }
    return 0;
}

/* Liefert den entfernten Knoten oder NULL */
struct knoten* entfernen_kopf(struct knoten* *kopfref) {
    struct knoten* kopf_alt;
    if ((kopfref==NULL)||(*kopfref==NULL)) return NULL;
    kopf_alt = *kopfref;
    *kopfref = (*kopfref)->next;
    return kopf_alt;
}


struct knoten* entfernen_ende(struct knoten* *kopfref) {
    struct knoten* vor_ende, *ende;
    if ((kopfref==NULL)||(*kopfref==NULL)) return NULL;
    if ((*kopfref)->next==NULL) {
        ende = *kopfref;
        *kopfref = NULL;
        return ende;
    }
    vor_ende = *kopfref;
    while (vor_ende->next->next!=NULL) {
        vor_ende = vor_ende->next;
    }
    ende = vor_ende->next;
    vor_ende->next = NULL;
    return ende;
}

struct knoten* entfernen(struct knoten* *kopfref, struct knoten* auszufueg) {
    struct knoten* vor_auszufueg;
    if ((auszufueg==NULL)||(kopfref==NULL)||(*kopfref==NULL)) return NULL;
    if (auszufueg==*kopfref) {
        *kopfref = (*kopfref)->next;
        return auszufueg;
    }
    vor_auszufueg = *kopfref;
    while (vor_auszufueg->next!=auszufueg) {
        if (vor_auszufueg->next == NULL) return NULL;
        vor_auszufueg = vor_auszufueg->next;
    }
    vor_auszufueg->next = auszufueg->next;
    return auszufueg;
}



int main(void) {
    struct knoten* kopf= NULL;
    
    struct knoten *neu4, *neu5, *neu6, *neu7, *such, *entf;

    neu5 = malloc(sizeof(*neu5));
    neu5->wert = 5;
    neu5->next = NULL;

    if (einfuegen_kopf(&kopf, neu5) != 0) {
      printf("Fehler beim einfügen\n"); 
      return -1;
    }

    neu6 = malloc(sizeof(*neu6));
    neu6->wert = 6;
    neu6->next = NULL;
    if (einfuegen_nach(neu5, neu6) != 0) {
      printf("Fehler beim einfügen\n"); 
      return -1;
    }

    durchlaufen(kopf);
   
    such= suchen(kopf, 5);
    if (such == NULL || such->wert != 5) {
      printf("Fehler: suchen. 5 nicht gefunden\n"); 
      return -1;
    }
    
    such= suchen(kopf, 6);
    if (such == NULL || such->wert != 6) {
      printf("Fehler: suchen. 6 nicht gefunden\n"); 
      return -1;
    }
    
    such= suchen(kopf, 7);
    if (such != NULL) {
      printf("Fehler: suchen. 7 gibt es gar nicht\n"); 
      return -1;
    }
    
    neu4 = malloc(sizeof(*neu4));
    neu4->wert = 4;
    neu4->next = NULL;
    if (einfuegen_kopf(&kopf, neu4) != 0) {
      printf("Fehler beim einfügen\n"); 
      return -1;
    }
    	
    	        
    such= suchen(kopf, 4);
    if (such == NULL || such->wert != 4) {
      printf("Fehler: suchen. 4 nicht gefunden\n"); 
      return -1;
    }
    
    such= suchen(kopf, 6);
    if (such == NULL || such->wert != 6) {
      printf("Fehler: suchen. 6 nicht gefunden\n"); 
      return -1;
    }
    

    neu7 = malloc(sizeof(*neu7));
    neu7->wert = 7;
    neu7->next = NULL;
    if (einfuegen_ende(&kopf, neu7) != 0) {
      printf("Fehler beim einfügen\n"); 
      return -1;
    }
    	
    	        
    such= suchen(kopf, 4);
    if (such == NULL || such->wert != 4) {
      printf("Fehler: suchen. 4 nicht gefunden\n"); 
      return -1;
    }
    
    such= suchen(kopf, 6);
    if (such == NULL || such->wert != 6) {
      printf("Fehler: suchen. 6 nicht gefunden\n"); 
      return -1;
    }
    
    such= suchen(kopf, 7);
    if (such == NULL || such->wert != 7) {
      printf("Fehler: suchen. 7 nicht gefunden\n"); 
      return -1;
    }
    

    entf= entfernen(&kopf, neu5);
    if (entf == NULL) {
      printf("Fehler: entfernen. 5 nicht gefunden\n"); 
      return -1;
    }

    entf= entfernen(&kopf, neu7);
    if (entf == NULL) {
      printf("Fehler: entfernen. 7 nicht gefunden\n"); 
      return -1;
    }

    entf= entfernen_kopf(&kopf);
    if (entf == NULL) {
      printf("Fehler: entfernen. 4 nicht gefunden\n"); 
      return -1;
    }
    
    durchlaufen(kopf);
    
    entf= entfernen_ende(&kopf);
    if (entf == NULL) {
      printf("Fehler: entfernen. 6 nicht gefunden\n"); 
      return -1;
    }

    printf("Leerer Durchlauf:");    
    durchlaufen(kopf);
    
    return 0;
}

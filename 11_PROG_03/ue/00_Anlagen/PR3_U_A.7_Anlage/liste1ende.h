/* liste1ende.h */

struct knoten {
    int wert; /* oder komplexere Daten */
    struct knoten* next;
};

void durchlaufen(struct knoten* kopf);

struct knoten* suchen(struct knoten* kopf, int gesuchter_wert);

/* Liefert -1 im Fehlerfall, sonst 0 */
int einfuegen_kopf(struct knoten* *kopfref, struct knoten* *enderef, struct knoten* einzufueg);

/* Liefert -1 im Fehlerfall, sonst 0 */
int einfuegen_nach(struct knoten* nachdiesem, struct knoten* einzufueg, struct knoten* *enderef);

/* Liefert -1 im Fehlerfall, sonst 0 */
int einfuegen_ende(struct knoten* *kopfref, struct knoten* *enderef, struct knoten* einzufueg);

/* Liefert den entfernten Knoten oder NULL */
struct knoten* entfernen_kopf(struct knoten* *kopfref, struct knoten* *enderef);

/* Liefert den entfernten Knoten oder NULL */
struct knoten* entfernen_ende(struct knoten* *kopfref, struct knoten* *enderef);

/* Liefert den entfernten Knoten oder NULL */
struct knoten* entfernen(struct knoten* *kopfref, struct knoten* *enderef, struct knoten* auszufueg);


// Musterlösung für die folgende Aufgabe.
//
// Schreiben Sie ein Programm, das positive ganze Zahlen mit bis 
// zu 20 Stellen erzeugen, addieren und ausgeben kann. Solch große 
// Zahlen werden in der Regel von den eingebauten skalaren Typen 
// nicht unterstützt. Die größte durch long darstellbare Zahl ist 
// meist 2^31-1 = 2147483647 mit 10 Dezimalstellen.
// 
// Programmieren Sie einen Strukturtyp namens int20, der die Zahl 
// intern z. B. als Folge von Zeichen (char) speichert, für jede 
// Dezimalziffer ein Zeichen. Eine Variable dieses Typs belegt 
// dann genau 20 Bytes. 
// 
// Folgender Code soll anschließend übersetzt werden:
// 
//     struct int20 a= create20("12345678901234567890");
//     struct int20 b= create20("100");
//     struct int20 sum= add20(a, b);
//     print20(a); printf("\n");
//     print20(b); printf("\n");
//     print20(sum); printf("\n");
// 
// Die gewünschte Ausgabe ist:
// 
// 12345678901234567890
// 100
// 12345678901234567990
// 
// Hinweise:
// • Für die Funktion create20 sieht der Prototyp so aus:
//   struct int20 create20(char* val);
// • Die Addition können Sie so implementieren, wie Sie sie 
//   einmal in der Schule gelernt haben (ziffernweise bei der 
//   letzten Ziffer beginnend, jeweils mit Übertragsrechnung).



#include <stdio.h>
#include <string.h>


struct int20 {
    unsigned char c[20];
};


struct int20 create20(char* val) {
    struct int20 result;
    int i;
    int len;

    len= strlen(val);
    memset(result.c, '0', 20);
    for (i= 0; i<len; i++) {
        result.c[i+20-len]= val[i];
    }
    return result;
}


/* liefert eine Zahl zwischen 0 und 9 */
unsigned char get_digit(struct int20 n, int pos) {
    return (n.c[19-pos] - (unsigned char)'0');
}


void print20(struct int20 n) {
    int pos= 0;
    char result[21];

    while (pos <20 && n.c[pos] == '0') pos++;
    if (pos == 20) {
      strcpy(result, "0");
    } else {
      int i=0;
      while (pos <20) {
          result[i]= n.c[pos];
          pos++; i++;
      }
      result[i]= '\0';
    }
    printf("%s", result);
}


struct int20 add20(struct int20 summand1, struct int20 summand2) {
    unsigned char i;
    struct int20 result;
    unsigned char uebertrag= 0;

    for (i= 0; i<20; i++) {
        unsigned char sum= get_digit(summand1, i) + get_digit(summand2, i) + uebertrag;
        if (sum > 9) uebertrag= 1; else uebertrag= 0;
        result.c[19-i]= '0' + (sum % 10);
    }
    return result;
}



int main(void) {
    struct int20 a= create20("12345678901234567890");
    struct int20 b= create20("100");

    struct int20 sum= add20(a, b);

    print20(a);  printf("\n");
    print20(b);  printf("\n");

    print20(sum);  printf("\n");

    return 0;
}

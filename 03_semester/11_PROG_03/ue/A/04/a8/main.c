/**
 * Gegeben seien die beiden folgenden Zahlen, die Sie bitte in einem Array vom Datentyp time_t (#include <time.h>) ablegen: 645703200, 49888800.
 * Geben Sie mit Hilfe der Bibliotheksfunktion ctime aus, um welches Datum es sich bei diesen zwei Zeitpunkten handelt. Mehr zur Bibliotheksfunktion 
 * ctime finden Sie z. B. hier: http://openbook.rheinwerk-verlag.de/c_von_a_bis_z/019_c_zeitroutinen_001.htm
 * Optional: Finden Sie mit Hilfe des Internet heraus, welche Bedeutung diese zwei Tage im Zusammenhang mit Ihrem Studium haben.
 */

#include <stdio.h>
#include <time.h>
#define arrlength 2

int main(void) {

    time_t times[arrlength] = {645703200, 49888800}; // sekunden ab dem 1970-01-01 01:00:00

    printf("Date 1 = %s\n", ctime(&times[0]));
    printf("Date 2 = %s\n", ctime(&times[1]));
 
    return 0;
}

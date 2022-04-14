/** Abgabeteam 3
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U09 Parametrisierte Methode mit Rückgabe
*/
public class Cent {
    public static void main(String[] args) {
        System.out.println(zaehle20CentStuecke(1235));
    }
    
    /** Methode zur Berechnung verbleibenden 20 Cent Stücken, da ganze Euros 
        nicht berücksichtigt werden
        Parameter: n >= 0
    */
    public static int zaehle20CentStuecke(int n) {
        return (n % 100) / 20;
    }
}
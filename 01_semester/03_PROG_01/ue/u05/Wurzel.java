/** Abgabeteam 3
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U08 Parametrisierte Methode mit Rückgabe / Math
*/
public class Wurzel {
    public static void main(String[] args) {
        System.out.println(zahlHoch1Durchn(256, 4));
    }
    
    /** Methode zur Berechnung der n-ten Wurzel zur Basis a
        Parameter: a >= 0; n alle reelle Zahlen
    */
    public static double zahlHoch1Durchn(double a, double n) {
        return Math.pow(a, 1 / n);
    }
}
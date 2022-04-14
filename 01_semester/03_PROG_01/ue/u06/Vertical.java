/** Abgabeteam 03
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U12 Parametrisierte Methode / String-Operationen
*/
public class Vertical {
    public static void main(String[] args) {
        vertical("Gut Holz!");
    }
    
    /** Methode zur Ausgabe einzelner chars im String
        Parameter: String
    */
    public static void vertical(String w) {
        for (int i = 0; i < w.length(); i++) {
            System.out.println(w.charAt(i));
        }
    }
}
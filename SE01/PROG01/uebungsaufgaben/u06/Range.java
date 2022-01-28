/** Abgabeteam 03
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U16 Fencepost loop und bedingte Ausführung
*/
import java.util.Scanner;
public class Range {
    /** Benutzeraufforderung zur Eingabe von ganzen Zahlenwerten
    */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben Sie zwei ganze Zahlen an: ");
        printRange(scan.nextInt(), scan.nextInt());
    }     
    
    /** Ausgabe der Zahlenfolge in aufsteigender oder absteigender Form
        je nachdem ob der 1. oder 2. Parameter am größten ist
        Parameter: 2 int Zahlenwerte
    */
    public static void printRange(int x, int y) {
        System.out.print("[" + x);
        
        if (x < y) {
            for (int i = x + 1; i <= y; i++) {
                System.out.print(", " + i);
            }
        }
        
        if (x > y) {
            for (int i = x - 1; i >= y; i--) {
                System.out.print(", " + i);
            }
        }
        
        System.out.print("]");
    }
}
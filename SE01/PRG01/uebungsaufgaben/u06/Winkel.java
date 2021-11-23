/** Abgabeteam 03
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U14 Interaktive Programme, Math
*/
import java.util.Scanner;
public class Winkel {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Dieses Programm errechnet die drei Winkel eines Dreiecks.");
        prompt('a');
        double a = value(console);
        prompt('b');
        double b = value(console);
        prompt('c');
        double c = value(console);
        calculate(a, b, c);
    }
    
    /** Ausgabe der Auffoderung des Benutzers eine Seitenlänge anzugeben
        Parameter: char => Seite
    */
    public static void prompt(char x) {
        System.out.print("Bitte Seitenlänge " + x + " eingeben: ");
    }
    
    /** Benutzer soll Seitenlänge angeben
        Parameter: Scanner Objekt  
    */
    public static double value(Scanner console) {
        return console.nextDouble();
    }
     
    /** Seitenlänge ausrechnen mit dem Kosinussatz
        Parameter: 3 positive double Werte 
    */
    public static void calculate(double a, double b, double c) {
        double gamma = kosinussatz(a, b, c);
        double beta = kosinussatz(a, c, b);
        double alpha = kosinussatz(b, c, a);
        
        alpha = round1(alpha);
        beta = round1(beta);
        gamma = round1(gamma);
        
        print("alpha", alpha);
        print("beta", beta);
        print("gamma", gamma);
    }
    
    /** Rundet eine gegebene Zahl auf eine Nachkommastelle. */
    public static double round1(double value) {
        if (Double.isNaN(value)) return value;
        if (Double.isInfinite(value)) return value;
        return Math.round(value * 10) / 10.0;
    }
    
    
    /** Mit Kosinussatz der jeweiligen Winkel berechnen
        Parameter: positive doubel Werte für die Seitenlängen
    */
    public static double kosinussatz(double a, double b, double c) {
        return 180/Math.PI * Math.acos((a*a+b*b-c*c)/(2*a*b));
    }
    
    /** Ausgabe der ausgerechneten Winkelwerte
        Parameter: Winkel x String  und der dazugehörige Winkelwert y double
    */ 
    public static void print(String x, double y) {
        System.out.println(x + " = " + y);
    }
}
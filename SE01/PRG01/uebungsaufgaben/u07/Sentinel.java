/** Abgabeteam 03
  * Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
  * U21 Sentinel-Schleife*/
import java.util.Scanner;
public class Sentinel {
    /** main Methode */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = prompt(scanner);
        String output = name;
        
        while (!name.isEmpty()) {
            /* ohne die if-Abfrage würde der 1. Name 2x gespeichert
             * aber wenn output am Anfang leer ist weiß ich nicht wie ich 
             * das Zaunpfahl-Primblem mit den Kommata löse */
            if (!name.equals(output)) {
                output = output + ", " + name;
            }
            name = prompt(scanner);
        }
        System.out.println("Willkommen an alle: " + output);
    }
    
    /** Eingabeauffoerung des Users eine Namen anzugeben */
    public static String prompt(Scanner scanner) {
        System.out.print("Geben Sie einen Namen ein (oder eine leere Zeile zum Beenden): ");
        return scanner.nextLine();
    }
}
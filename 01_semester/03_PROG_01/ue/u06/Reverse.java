/** Abgabeteam 03
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U13 Interaktive Programme
*/
import java.util.Scanner;
public class Reverse {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Bitte geben Sie Ihren vollen Namen ein: ");
        String name = console.nextLine();
        
        int leer = 0;
        while (name.charAt(leer) != ' ') {
            leer = leer + 1;
        }
        String vorname = name.substring(0, leer);
        String nachname = name.substring(leer + 1);
        
        System.out.println("Ihr Name in umgekehrter Schreibweise ist: " + nachname + ", " + vorname);
    }     
}
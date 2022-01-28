/** * Abgabeteam 03
    * Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    * U23 Benutzereingaben und Programmlogik */
import java.util.Scanner;
public class Jahreszeit {
    public static final int MAXDAYS = 31;
    public static final int MAXMONTHS = 12;
    /** main methode */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int days = 0;
        int months = 0;
        while (true) { // as long as no valid input for days & months
            
            // last parameter usefuil to know if dealing with days or months
            days = ganzzahlInBereichLesen(console, "Tag (1-" + MAXDAYS + "): ", MAXDAYS);
            months = ganzzahlInBereichLesen(console, "Monat (1-" + MAXMONTHS + "): ", MAXMONTHS);
            
            // check if months has too many days
            switch (months) {
            case 2:
                if (days > MAXDAYS - 2) {
                    invalidDate();
                    continue;
                }
                break;
            case 4:
                if (days > MAXDAYS - 1) {
                    invalidDate();
                    continue;
                }
                break;
            case 6:
                if (days > MAXDAYS - 1) {
                    invalidDate();
                    continue;
                }
                break;
            case 9:
                if (days > MAXDAYS - 1) {
                    invalidDate();
                    continue;
                }
                break;
            case 11:
                if (days > MAXDAYS - 1) {
                    invalidDate();
                    continue;
                }
                break;
            }
            
            break;
        }
        
        if (months < 3 || months == 3 && days <= 19) {
            printWinter();
        } else if (months == 3 && days >= 20 || (months >= 4 && months <= 5) || months == 6 && days <= 20) {
            System.out.println("Frühling");
        } else if (months == 6 && days >= 21 || (months >= 7 && months <= 8) || months == 9 && days <= 21) {
            System.out.println("Sommer");
        } else if (months == 9 && days >= 22 || (months >= 10 && months <= 11) || months == 12 && days <= 20) {
            System.out.println("Herbst");
        } else {
            printWinter();
        }
    }
    
    /** check boundaries of days and months*/
    public static int ganzzahlInBereichLesen(Scanner console, String prompt, int max) {
        while (true) { // as long as no valid input  
            int input = ganzzahlLesen(console, prompt);
            if (max == MAXDAYS && input > MAXDAYS || input <= 0) {
                invalidInterval();
                continue;
            } else if (max == MAXMONTHS && input > MAXMONTHS ||input <= 0) {
                invalidInterval();
                continue;
            }
            return input;
        }
    }
    
    /** checks input wheather it is a number */
    public static int ganzzahlLesen(Scanner console, String prompt) {
        while (true) { // as long as no valid input     
            System.out.print(prompt);
            if (console.hasNextInt()) {
                return console.nextInt();
            } else {
                console.next();
                System.out.println("Bitte eine ganze Zahl eingeben.");
            }
        }
        
    }
    
    /** print invalid boundaries */
    public static void invalidInterval() {
        System.out.println("Nicht im geforderten Bereich.");
    }
    
    /** print invalid date */
    public static void invalidDate() {
        System.out.println("Datum ist ungültig. Wiederholen.");
    }
    
    /** print winter */
    public static void printWinter() {
        System.out.println("Winter");
    }
}
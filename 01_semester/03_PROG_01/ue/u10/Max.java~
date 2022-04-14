/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U28 Kommandozeilenparameter*/
import java.util.Scanner;
public class Max {
    /** main method*/
    public static void main(String[] args) {
        boolean systemExit = false; // da Graja Probleme mit System.exit(-1)
        if (args.length != 3) {
            System.out.println("Bitte genau 3 Parameter angeben");
            //System.exit(-1)
            systemExit = true;
        }
        if (systemExit != true) {
            Scanner input = new Scanner(args[0] + " " + args[1] + " " + args[2]);
            
            int number = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < args.length; i++) {
                if (systemExit != true) {
                    if (input.hasNextInt()){
                        number = input.nextInt();
                        if (number > max) {
                            max = number;
                        } 
                    } else {
                        System.out.println("Ungültige Parameter.");
                        //System.exit(1);
                        systemExit = true;
                    }
                }
            }
            if (systemExit != true) {
                System.out.println("Maximum: " + max);
            }
            input.close();
        }
    }
}
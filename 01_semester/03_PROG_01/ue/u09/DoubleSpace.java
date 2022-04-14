/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U24 Dateien lesen und schreiben*/
import java.io.*;
import java.util.Scanner;
public class DoubleSpace {
    /** main Methode: Aufruf der doubleSpace Methode*/
    public static void main(String[] args) {
        doubleSpace2();
    }
    
    /** Parameter: 2 Strings */
    public static void doubleSpace(String s1, String s2) {
        Scanner input = null;
        PrintStream output = null;
        try {
            input = new Scanner(new File(s1));
            output = new PrintStream(new File(s2));
        
            String outputS = read(input);
            //System.out.println(outputS);
            output.print(outputS + "\n");
        
            while (input.hasNextLine()) {
                outputS = "\n" + read(input);
                output.println(outputS);
                //System.out.println(outputS);
            }
        
        } catch (FileNotFoundException e) {
            System.out.print(e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
    
    /** *Parameter: Scanner
        *returns String*/
    public static String read(Scanner s) {
        if (s.hasNextLine()) {
            return s.nextLine();
        }
        return null;
    }
    
    /** *verstehen nicht genau was gefordert war, haben es deswegen
        *einfach so gemacht*/
    public static void doubleSpace2() {
        doubleSpace("inputText.txt", "outputText.txt");
    }
}
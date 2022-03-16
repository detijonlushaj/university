/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U25 Textdateien vergleichen*/
import java.io.*;
import java.util.Scanner;
public class Diff {
    /** call diff*/
    public static void main(String[] args) {
        diff("text1.txt", "text2.txt");
    }
    
    /** *Parameter: 2 Strings
        *returns: - */
    public static void diff(String s1, String s2) {
        Scanner text1 = null;
        Scanner text2 = null;
        String text1Str = null;
        String text2Str = null;
        String error = null;
        int counter = 1;
        
        try {
            text1 = new Scanner(new File(s1));
            text2 = new Scanner(new File(s2));
        } catch (FileNotFoundException e) {
            if (text1 == null) {
                System.out.println("Kann Datei nicht finden: " + s1);
            } else {
                System.out.println("Kann Datei nicht finden: " + s2);
            }
            //System.exit(-1); darf man nicht benutzen, da Graja damit Probleme hat :/
        }
        
        // wegen Graja muss ich deshalb checken ob beide Dateien existieren
        // damit der nächste Part anderenfalls nicht ausgeführt wird
        if (text1 != null && text2 != null) {
            while (true) {
                if (!(text1.hasNextLine() || text2.hasNextLine())) {
                    break;
                }
                
                if (text1.hasNextLine()) {
                    text1Str = text1.nextLine();
                } else {
                    text1Str = "";       
                }
                
                if (text2.hasNextLine()) {
                    text2Str = text2.nextLine();
                } else {
                    text2Str = "";
                }
                
                if (!(text1Str.equals(text2Str))) {
                    if (error != null) {
                        error = error + "Zeile " + counter + ":\n< " + text1Str + "\n> " + text2Str + "\n\n";
                    } else {
                        error = "Zeile " + counter + ":\n< " + text1Str + "\n> " + text2Str + "\n\n";
                    }
                }
                counter++;
            }
            if (error != null) {
                System.out.print("Unterschiede gefunden\n" + error);
            } else {
                System.out.print("Keine Unterschiede gefunden\n");
            }
            text1.close();
            text2.close();
        }
    }
}
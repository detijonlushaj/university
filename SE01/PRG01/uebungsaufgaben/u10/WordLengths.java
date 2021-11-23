/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U26 Wortlängen in einer Datei*/ 
import java.util.Scanner;
import java.io.*;
public class WordLengths {
    /** call wordLengths*/
    public static void main(String[] args) throws FileNotFoundException {
        wordLengths("words.txt");
    }
    
    /** Parameter: String s
        returns: - */
    public static void wordLengths(String s) throws FileNotFoundException {
        Scanner input = new Scanner(new File(s));
        int[] count = new int[81];
        
        String word = null;
        int maxWord = 0;
        while (input.hasNext()) {
            word = input.next();
            count[word.length()]++;
            if (word.length() >= maxWord) {
                maxWord = word.length();
            }
        }
        
        for (int i = 1; i < maxWord + 1; i++) {
            System.out.print(i + ": " + count[i]);
            // formatting 
            if (i < 10) {
                System.out.print(" ");
            }
            if (count[i] < 10) {
                System.out.print("   ");
            } else {
                System.out.print("  ");
            }
            
            for (int j = 0; j < count[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        input.close();
    }
}
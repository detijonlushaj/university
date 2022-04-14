import java.io.*;
import java.util.Scanner;
public class Histogramm {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("punkte.txt"));
        int[] counts = new int[10]; 
        int p = 0;
        
        while (input.hasNextInt()) {
            p = input.nextInt();
            counts[p]++;
        }
        
        for (int i = 0; i < counts.length; i++) {
            System.out.print(i+ ": ");
            for (int j = 0; j < counts[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
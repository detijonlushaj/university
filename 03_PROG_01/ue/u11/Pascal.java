/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U29 Pascalsches Dreieck*/
import java.util.Scanner;
public class Pascal {
    /** main Methode */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Wieviele Zeilen? ");
        int zeilen = console.nextInt();
        int[][] dreieck = new int[zeilen][];
        print(calculate(zeilen, dreieck));
    }
    
    /** *Parameter: int zeilen => zeilen > 0, int[][] dreieck
        *returns: int[][] */
    public static int[][] calculate(int zeilen, int[][] dreieck) {
        for (int i=0; i < zeilen; i++) {
            dreieck[i]= new int[i+1];
            dreieck[i][0]= 1;
            dreieck[i][i]= 1;
            for (int j = 1; j < dreieck[i].length - 1; j++) {
                dreieck[i][j]= dreieck[i-1][j] + dreieck[i-1][j-1];
            }
        }        
        return dreieck;
    }
    
    /** *Parameter: int[][] dreieck
        *returns: - */
    public static void print(int[][] dreieck) {
        for (int i = 0; i < dreieck.length; i++) {
            for (int j = 0; j < dreieck[i].length; j++) {
                System.out.print(dreieck[i][j] + " ");
            }
            System.out.println();
        }
    }
}
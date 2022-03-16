/** Abgabeteam 03
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U15 Kumulatives Produkt
*/
import java.util.Scanner;
public class KumulProd {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Wieviele Zahlen? ");
        int n = console.nextInt();
        int product = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + "-te Zahl: ");
            int tmp = console.nextInt();
            product *= tmp;
        }
        System.out.println("Das kumulative Produkt ist: " + product);
    }     
}
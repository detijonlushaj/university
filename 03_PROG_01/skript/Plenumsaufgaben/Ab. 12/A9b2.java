import java.util.Scanner;
public class A9b2 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Bitte eine Zahl eingeben: ");
        int n = console.nextInt();
        System.out.println(sterne(n));
    }
    
    public static String sterne(int n) {
        if (n == 0) {
            return "*";
        } else {
            String s = sterne(n-1);
            return s+s;
        }
    }
}
import java.util.Scanner;
public class Au_4d {
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        System.out.print("Geben Sie eine positive ganze Zahl an: ");
        int n = scan.nextInt();
        System.out.println(countFactors(n) + " Teiler hat die Zahl " + n);
    }
    
    public static int countFactors(int n) {
        int count = 1;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                count++; // für den Teiler n
                System.out.println(i + " ist ein Teiler von " + n + ": " + n + " / " + i + " = " + (n / i));
            }
        }
        return count;
    }
}
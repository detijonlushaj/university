import java.util.Scanner;
public class A9b3 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("bitte ein Word angeben: ");
        String s = console.next();
        System.out.println(istPalindrom(s));
    }
    
    public static boolean istPalindrom(String s) {
        if (s.length() <= 2) {
            return true;
        } else {
            return Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(s.charAt(s.length() - 1)) 
                    && istPalindrom(s.substring(1, s.length() - 1));
        }
    }
}
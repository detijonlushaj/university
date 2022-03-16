import java.util.Scanner;
public class Au_4a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Biite eine Zahl eingeben: ");
        int zahl = scanner.nextInt();
        
        if (zahl % 2 == 0) {
            System.out.println("Die Zahl " + zahl + " ist gerade");
        } else {
            System.out.println("Die Zahl " + zahl + " ist ungerade");
        }
    }
}
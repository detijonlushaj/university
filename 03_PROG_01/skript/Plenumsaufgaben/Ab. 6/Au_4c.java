import java.util.Scanner;
public class Au_4c {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String s= scanner.next();
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        System.out.println("Buchstaben: " + count);

    }
}
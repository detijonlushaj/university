import java.util.Scanner;
public class Sentinel {
    public static final int SENTINEL = -1;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        int number = readNumber(scan);
        
        while (number != SENTINEL) {
            sum += number*number;
            System.out.println("Sum of squares: " + sum);
            
            number = readNumber(scan);
        }
        System.out.println("Total sum of squares is " + sum);
    }
    
    public static int readNumber(Scanner scan){
        System.out.print("Enter a number (-1 to quit): ");
        return scan.nextInt();
    }
}
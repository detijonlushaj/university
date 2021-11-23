import java.util.Arrays;
public class A7c {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50, 100};
        
        double averageZ = average(numbers);
        System.out.println("average: " + averageZ);
        
        System.out.println("gesuchter Wert gefunden: " + contains(numbers, 10));
        
        double[] dNumbers = {0.1, 0.9, 2.5, 3.1, 5.0};
        roundAll(dNumbers);
        System.out.println(Arrays.toString(dNumbers));
    }
    
    public static double average(int[] numbers) {
        int x = 0;
        for (int i = 0; i < numbers.length; i++) {
            x += numbers[i];
        }
        return (double)x/numbers.length;
    }
    
    public static boolean contains(int[] numbers, int x) {
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == x) {
                return true;
            }
        }
        return false;
    }
    
    public static void roundAll(double[] dNumbers) {
        for (int i = 0; i < dNumbers.length; i++) {
            dNumbers[i] = Math.round(dNumbers[i]);
        }
    }
}
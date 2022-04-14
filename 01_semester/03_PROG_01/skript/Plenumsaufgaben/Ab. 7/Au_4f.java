import java.util.Random;
public class Au_4f {
    public static void main(String[] args) {
        Random rand = new Random();
        int x = rand.nextInt(101);
        System.out.println("Zahlen zwischen 0 - 100: " + x);
        x = rand.nextInt(100) + 1;
        System.out.println("Zahlen zwischen 0 - 100: " + x);
        x = rand.nextInt(17 - 4 + 1) + 4;
        System.out.println("Zahlen zwischen 0 - 100: " + x);
    }
}
import java.util.Random;
public class ZufallIndex {
    public static void main(String[] args) {
        Random rand = new Random();
        String text = "AEIOU";
        int n = rand.nextInt(text.length());
        System.out.println(text.charAt(n));
    }
}
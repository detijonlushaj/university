public class Turn {
    public static void main(String[] args) {
        int x= 8;
        int y= 3;
        
        x = x + y;
        y = x - y;
        x = -1 * (x-y);
        
        System.out.println(x + " " + y);
    }
}
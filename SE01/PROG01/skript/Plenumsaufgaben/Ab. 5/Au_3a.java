public class Au_3a {
    public static void main(String[] args) {
        drawBox(10, 3);
        drawBox(5, 4);
    }
    
    public static void drawBox(int width, int height) {
        drawHorizontal(width);
        
        for (int i = 0; i < height - 2; i++) {
            System.out.print("*");
            drawSpaces(width);
            System.out.println("*");
        }
        
        drawHorizontal(width);
    }

    public static void drawHorizontal(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
    
    public static void drawSpaces(int x) {
        for (int i = 0; i < x - 2; i++) {
            System.out.print(" ");
        }
    }
}
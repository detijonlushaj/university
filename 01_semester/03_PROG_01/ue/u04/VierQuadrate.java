/** Abgabeteam 3
    Detijon Lushaj, Furkan Aydin, Schehat Abdel Kader
    U07 Zeichnen einer komplexen Figur mit for-Schleifen und statischen Methoden
*/
public class VierQuadrate {
    public static final int SIZE = 3;
    
    /** main
    */
    public static void main(String[] args) {
        print();
    }
    
    /** draw row
    */
    public static void drawRow() {
        drawEqual();
        System.out.print("+");
        drawEqual();
        System.out.println();
    }
    
    /** draw equal char
    */
    public static void drawEqual() {
        for (int i = 0; i < SIZE + 1; i++) {
            System.out.print("=");
        }
    }
    
    /** draw column
    */
    public static void drawCol() {
        drawHash();
        drawSpace();
        System.out.print("|");
        drawSpace();
        drawHash();
        System.out.println();
    }
    
    /** draw hashtag symbol
    */
    public static void drawHash() {     
        System.out.print("#");
    }
    
    /** draw 3 space char
    */
    public static void drawSpace() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" ");
        }
    }
    
    /** draw the blocks
    */
    public static void print() {
        drawRow();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < SIZE; j++) {
                drawCol();
            }
            drawRow();
        }
    }
}
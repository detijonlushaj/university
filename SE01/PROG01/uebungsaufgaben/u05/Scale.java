/** Abgabeteam 3
    Furkan Aydin, Detijon Lushaj, Schehat Abdel Kader
    U11 Parametrisierte Methoden
*/
import java.awt.Point;
public class Scale {
    public static void main(String[] args) {
        int x = 4;
        int y = 3;
        int faktor = 2;
        Point p = new Point(x, y);
        
        scale(p, faktor);
        
        System.out.println("(" + p.x + ", " + p.y + ")" );
    }
    
    public static void scale(Point p, int faktor) {
        p.translate(p.x*faktor - p.x, p.y*faktor - p.y);
    }
}
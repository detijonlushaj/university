import java.awt.Graphics;
/**
 * Klassen invariante x und y sind positiv
 * @author lushaj
 *
 */
public class Loc {
    private int x;
    private int y;

    public Loc(int initialX, int initialY) { 
        setLocation(initialX,initialY);

    }
    public Loc() { 
        this(0, 0); // Verkettung von Konstruktoren
    }

    /** A "read-only" access to the x attribute ("accessor")*/
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void draw(Graphics g , int r) {
        g.fillOval(this.x, this.y, r, r);   //this greift auf das Objekt in dem  ich mich befinde zu
        g.drawString(toString(), x, y);
    }

    public void setLocation(int x, int y) {
        if ( x < 0 || y < 00) {
            throw new IllegalArgumentException("x und y muessen groesser null sein");
        }
        this.x = x; //Hier ist ein This notwendig
        this.y = y;
    }

    public void transelate(int dx, int dy) {
        setLocation(x + dx,y + dy);
    }
    public double distance(Loc b) {
        return (Math.sqrt(Math.pow((b.x-x), 2)+Math.pow(b.y-y, 2)));
    }
    public double distanceFromOrgin(Graphics g , int r) {
        return (Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));

    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public int manhattanDistance(Loc l2) {
        int x;
        int y;
        if(this.getX() >= l2.getX()) {
            x = Math.abs(this.getX()-l2.getX());
        } else {
            x = Math.abs(l2.getX()-this.getX());
        }
        if(this.getY() >= l2.getY()) {
            y = Math.abs(this.getY()-l2.getY());
        } else {
            y = Math.abs(l2.getY()-this.getY());
        }

        return x+y;
    }

}


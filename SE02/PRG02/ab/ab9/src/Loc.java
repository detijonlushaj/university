import java.awt.Graphics;

public class Loc {
    private int x;
    private int y;
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public Loc(int initx, int inity) {
        x = initx;
        y = inity;
    }
    
    public Loc() {
        x = 0;
        y = 0;
    }
    
    public void draw(Graphics graph) {
        graph.fillOval(x, y, 3, 3);
        graph.drawString(toString(), x, y);
    }
    
    public void setLocations(int newx, int newy) {
        x = newx;
        y = newy;
    }
    
    public void translate(int dx, int dy) {
        x = x + dx;
        y = y + dy;
    }
    
    public double distance(Loc loc) {
        double dx = x - loc.x;
        double dy = y - loc.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    public double distanceFromOrigin() {
        return Math.sqrt(x * x - y*y);
    }
}

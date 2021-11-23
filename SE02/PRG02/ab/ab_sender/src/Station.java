import java.awt.Color;
import java.awt.Graphics;

public class Station {
    private Loc sender;
    private int radius;
    
    public Station(int senderx, int sendery, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius muss > 0 sein");
        }
        sender= new Loc(senderx, sendery);
        this.radius= radius;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(sender.getX() - radius, sender.getY() - radius, 2 * radius, 2 * radius);
    }
    
    public void drawReceiver(Graphics g, Loc r) {
        if (sender.distance(r) <= radius) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLACK);
        }
        r.draw(g);
    }
}

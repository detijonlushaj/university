//package de.hsh.prog.v02;
import java.awt.Graphics;

/**
 * @author lushaj
 * condition: x and y >= 0 
 */
public class Loc {
  private int x;
  private int y;

      /**
       * set x and y to a specific location 
       * @param initialX >= 0
       * @param initialY >= 0
       * @throws IllegalArgumentException if x or y < 0
       */
      public Loc(int initialX, int initialY) {
          setLocation(initialX, initialY);
      }
    
      public Loc() {
        this(0, 0);
      }
    
      // Fortsetzung rechts �
      public int getX() {
        return x;
      }
    
      public int getY() {
        return y;
      }
    
      public void draw(Graphics g) {
        g.fillOval(x, y, 3, 3);
        g.drawString("("+x+", "+y+")",x,y);
      }
    
      /**
       * set x and y to a specific location 
       * @param newx >= 0
       * @param newy >= 0
       * @throws IllegalArgumentException if x or y < 0
       */
      public void setLocation(int x, int y) {
          if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x und y m�ssen >= 0 sein");
          }
          this.x = x;
          this.x = y;
      }
    
      /**
       * offset x and y by dx and dy
       * @param final x >= 0
       * @param final >= 0
       * @throws IllegalArgumentException if final x or y < 0
       */
      public void translate(int dx, int dy) {
          setLocation(x + dx, y + dy);
      }
    
      public double distance(Loc other){
        int dx= x - other.x;
        int dy= y - other.y;
        return Math.sqrt(dx*dx + dy*dy);
      }
    
      public double distanceFromOrigin() {
        Loc origin= new Loc();
        return distance(origin);
      }
    
      public String toString() {
        return "(" + x + ", " + y + ")";
      }
}
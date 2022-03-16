package gamelogic;

public class Vector {
    private double x;
    private double y;
    
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y= y;
    }

    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    
    public void add(double d, double e) {
        this.x += d;
        this.y += e;
    }
    
    public void add(Vector other) {
        this.add(other.getX(), other.getY());
    }
    
    public void multiply(double factor) {
        this.x *= factor;
        this.y *= factor;
    }
}

package gamelogic;

public class Rectangle {
    private double x;
    private double y;
    private double width;
    private double height;
    
    
    public Rectangle(double x, double y,double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void  setWidth(double width) {
        this.width = width;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getWidth() {
        return this.width;
    }
    
    public double getHeight() {
        return this.height;
    }
    
    
    
    
    /*  
     * returns true if other rectangle overlaps this rectangle
     * */
    public boolean overlaps(Rectangle other) {
        boolean noOverlap =
                this.x + this.width-1 < other.x ||
                other.x + other.width-1 < this.x ||
                this.y + this.height-1 < other.y ||
                other.y + other.height-1 < this.y;
        
        return !noOverlap;
    }
}

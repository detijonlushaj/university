package gameObjects.gameEngine;
/**
 * Class to create an object with height and width and
 * a position
 * */

public class Rectangle {
    double x;
    double y;
    double width;
    double heigth;

    //default constructor
    public Rectangle() {
        this.setPosition(0,0);
        this.setSize(1,1);
    }

    //Constructor with parameters
    public Rectangle(double x, double y, double w, double h) {
        this.setPosition(x,y);
        this.setSize(w,h);
    }

    //setter for position
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //getter for x-position
    public double getX() {
        return this.x;
    }

    //getter for y-position
    public double getY() {
        return this.y;
    }

    //setter for the size
    public void setSize(double w, double h) {
        this.width = w;
        this.heigth = h;
    }

    //looks if this rectangle overlaps an another
    public boolean overlaps(Rectangle other) {
        boolean noOverlap = this.x + this.width < other.x ||
                            other.x + other.width < this.x ||
                            this.y + this.heigth < other.y ||
                            other.y + other.heigth < this.y;
        return !noOverlap;
    }
}

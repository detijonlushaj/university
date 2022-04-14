package gameObjects.gameEngine;
/**
 * This class calculate or set the x and y position from an object
 * */
public class Vector {
    public double x;
    public double y;

    //default constructor
    public Vector() {
        this.set(0,0);
    }

    //constructor with parameters
    public Vector(double x, double y) {
        this.set(x,y);
    }

    //setter
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    //add new x and y values to the object x and y
    public void add(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    //add a whole Vector to this vector
    public void add(Vector other) {
        this.add(other.x, other.y);
    }

    //multiply a value on x and y
    public void multiply (double m) {
        this.x *= m;
        this.y *= m;
    }

    //getter for the length
    public double getLength() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    //setter for the length
    public void setLength(double L) {
        double currentLength = this.getLength();
        if (currentLength == 0) {
            return;
        }
        this.multiply(1/currentLength);
        this.multiply(L);
    }

    //getter for the angle
    public double getAngle() {
        return Math.toDegrees(Math.atan2(this.y,this.x));
    }

    //setter for the angle
    public void setAngle(double angleDegress) {
        double L = this.getLength();
        double angleRadians = Math.toRadians(angleDegress);
        this.x = L * Math.cos(angleRadians);
        this.y = L * Math.sin(angleRadians);
    }
}

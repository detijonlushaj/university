public class Rectangle implements Shape {
    private double height, width;

    /** Constructs a new circle with the given radius. */
    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    /** Returns the area of this circle. */
    @Override
    public double area() {
        return height * width;
    }

    /** Returns the perimeter of this circle. */
    @Override
    public double perimeter() {
        return 2.0 * (height + width);
    }
}

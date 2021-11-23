import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Shape> shape= new ArrayList<Shape>();
        shape.add(new Rectangle(1.7, 0.8));
        shape.add(new Circle(2.2));
        double totalArea= 0.0;
        for (Shape s : shape) {
            totalArea += s.area();
        }
        System.out.println("Total area: " + totalArea);

    }

}

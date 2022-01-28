import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Bruch> b = new HashSet();
        Bruch b1 = new Bruch(48, -60);
        Bruch b2 = new Bruch(-48, 60);
//        System.out.println(b1.zaehler / b1.ggt + " " + b1.nenner / b1.ggt);
//        System.out.println(b2.zaehler / b2.ggt + " " + b2.nenner / b2.ggt);
//        System.out.println(b1.hashCode() + " " + b2.hashCode());
//        b.add(b1);
        System.out.println(b1.hashCode());
        System.out.println(b2.hashCode());
        System.out.println(b1.equals(b2));
    }

}

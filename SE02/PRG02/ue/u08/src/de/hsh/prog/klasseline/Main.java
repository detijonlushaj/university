package de.hsh.prog.klasseline;

public class Main {
    public static void main(String[] args) {
        Line l = new Line(5, 3, 6, 4);
        System.out.println(l);
        Line a = new Line(l, true);
        System.out.println(a);
        l.getP1().setLocation(1, 1);
        System.out.println(l);
        System.out.println(a);
    }
    
}

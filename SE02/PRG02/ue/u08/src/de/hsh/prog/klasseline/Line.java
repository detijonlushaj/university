/**
 * Gruppe 03
 * @author lushaj
 * U08
 */
package de.hsh.prog.klasseline;

import java.awt.Graphics;

public class Line {
    private Loc p1, p2;
    
    /**
     * Initializes a line class
     * @param p1x
     * @param p1y
     * @param p2x
     * @param p2y
     */
    public Line(int p1x, int p1y, int p2x, int p2y) {
        p1 = new Loc(p1x, p1y);
        p2 = new Loc(p2x, p2y);
    }
    
    /**
     * initializes a line class with both points being at (0, 0)
     */
    public Line() {
        this(0, 0, 0, 0);
    }
    
    /**
     * Initializes a line class
     * @param p1
     * @param p2
     */
    public Line(Loc p1, Loc p2) {
        this(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
    
    /**
     * copy constructor of a line
     * @param line
     * @param bool if true => deep copy else flat copy
     */
    public Line(Line line, boolean bool) {
        if (bool) {
            p1 = new Loc(line.p1);
            p2 = new Loc(line.p2);
        } else {
            p1 = line.p1;
            p2 = line.p2;
        }
    }
    
    /**
     * returns String of objects
     */
    public String toString() {
        return "[" + p1.toString() + ", " + p2.toString() + "]";
    }
    
    /**
     * 
     * @return p1
     */
    public Loc getP1() {
        return p1;
    }
    
    /**
     * 
     * @return p2
     */
    public Loc getP2() {
        return p2;
    }
    
    /**
     * 
     * @return length between 2 points 
     */
    public double getLength() {
        return p1.distance(p2);
    }
    
    /**
     * draws a line between 2 points
     * @param g
     */
    public void draw(Graphics g) {
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}

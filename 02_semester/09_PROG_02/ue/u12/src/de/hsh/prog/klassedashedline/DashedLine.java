/**
 * Gruppe 03
 * @author lushaj
 * U12 Gestrichelte Linien zeichnen 
 */
package de.hsh.prog.klassedashedline;

import java.awt.Graphics;
import java.util.Arrays;

public class DashedLine extends Line {
    private int[] dashes;

    /**
     * constructor
     * @param p1 consists of attribute x and y which are integers
     * @param p2
     * @param dashes
     */
    public DashedLine (Loc p1, Loc p2, int[] dashes) {
        super(p1, p2);
        this.dashes = dashes;
    }

    /**
     * toString method of 2 Points and elements of integer array dashes
     */
    @Override public String toString() {
        return "[" + super.toString() + ", dashes=" + Arrays.toString(dashes) + "]"; 
    }

    /**
     * draw lines
     */

    @Override public void draw(Graphics g) {
        double dX = this.getP2().getX() - this.getP1().getX();
        double dY = this.getP2().getY() - this.getP1().getY();
        double totalLen = this.getP1().distance(this.getP2());
        double currentLen = 0;
        double dashLen = 0;

        double nextx;
        double nexty;
        double x = (double) this.getP1().getX();
        double y = (double) this.getP1().getY();

        int dashCount = 0;
        while (currentLen < totalLen) {
            if (dashCount < dashes.length) {
                dashLen = dashes[dashCount];
                dashCount++;
            } else {
                dashCount = 0;
                dashLen = dashes[dashCount];
                dashCount++;
            }

            if (dashLen + currentLen > totalLen) {
                dashLen= totalLen - currentLen;
            }

            nextx = x + dX * dashLen / totalLen;
            nexty = y + dY * dashLen / totalLen;

            currentLen = currentLen + dashLen;

            if (dashCount % 2 != 0) {
                new Line(new Loc((int) x, (int) y), new Loc((int) nextx,(int) nexty)).draw(g);
            }

            x= nextx; 
            y= nexty;
        }
    }
}

/**
 * Gruppe 03
 * @author lushaj
 * U12 Gestrichelte Linien zeichnen
 */
package de.hsh.prog.klassedashedline;

import com.bjp.DrawingPanel;

public class Main {

    public static void main(String[] args) {
        DrawingPanel pnl = new DrawingPanel(400, 300);
        int[] d= new int[] { 15, 10 };
        int cx= pnl.getWidth()/2, cy= pnl.getHeight()/2; // center
        int minDim= Math.min(pnl.getHeight(), pnl.getWidth());
        double r1= minDim/10.0 /*inner radius*/, r2= minDim*4.2/10.0 /*outer radius*/;
        int n= 23; // number of rays
        double incr= Math.PI*2/n; // increment
        for (double arc= 0.2*incr; arc < Math.PI*2; arc += incr) {
            double cos= Math.cos(arc), sin= Math.sin(arc);
            Loc p1= new Loc((int)(cx+r1*cos), (int)(cy+r1*sin));
            Loc p2= new Loc((int)(cx+r2*cos), (int)(cy+r2*sin));
            DashedLine dl= new DashedLine(p1, p2, d); 
            dl.draw(pnl.getGraphics());
        }
    }
}

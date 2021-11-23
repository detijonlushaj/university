/**
 * Gruppe 03
 * @author lushaj
 * U10
 */
package de.hsh.fakturierung.rechnung;

import java.util.ArrayList;

public class Rechnung {
    private int nummer;
    private ArrayList<Rechnungsposition> positionen = new ArrayList();;
    
    /**
     * Initialization
     * @param nummer
     */
    public Rechnung (int nummer) {
        this.nummer = nummer;
        //positionen = new ArrayList<Rechnungsposition>();
    }
    
    /**
     * adds an article and price to positionen by creating a new Rechnungspositionen class 
     * @param artikelnummer
     * @param preis
     */
    public void addPos(int artikelnummer, double preis) {
        positionen.add(new Rechnungsposition(artikelnummer, preis));
    }
    
    /**
     * 
     * @param pos
     * @return artikelnummer
     */
    public int getArtikelnummer(int pos) {
        return positionen.get(pos).getArtikelnummer();
    }
    
    /**
     * 
     * @param pos
     * @return preis
     */
    public double getPreis(int pos) {
        return positionen.get(pos).getPreis();
    }
}

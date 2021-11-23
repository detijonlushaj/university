/**
 * Gruppe 03
 * @author lushaj
 * U13 Zahlenarray mit Zeitmessung
 */
package de.hsh.zahlenarraytest;

import de.hsh.prog.zahlenarray.Zahlenarray;

import java.util.Arrays;

public class MeinZahlenarray extends Zahlenarray {
    private Zeitmesser time = new Zeitmesser();
    private Zeitmesser timeTest = new Zeitmesser();
    private long anzahl;
    
    /**
     * constructor
     * @param anzahl
     * @param max
     */
    public MeinZahlenarray(int anzahl, int max) {
        super(anzahl, max);
        Arrays.sort(getZahlenArray());
        this.anzahl = anzahl;
    }
    
    /**
     * checks is value in array with 2 methods
     */
    @Override public boolean istEnthalten(int zahl) {
        time.start();
        boolean bool = super.istEnthalten(zahl);
        time.stop();
        
        timeTest.start();
        Arrays.binarySearch(getZahlenArray(), zahl);
        timeTest.stop();
        
        return bool;
    }
    
    /**
     * of regualar iterating solution for finding number in array
     * @return time inverval
     */
    public double getDurchschnittlicheAbfragezeit() {
        return (double) time.getGemesseneGesamtzeit() / anzahl;
    }
    
    /**
     * of binary seach solution for finding number in array in more efficient way
     * @return time inverval
     */
    public double getDurchschnittlicheAbfragezeitTest() {
        return (double) timeTest.getGemesseneGesamtzeit() / anzahl;
    }
}

/**
 * Gruppe 03
 * @author lushaj
 * U13 Zahlenarray mit Zeitmessung
 */
package de.hsh.zahlenarraytest;

import de.hsh.prog.zahlenarray.*;

public class Main {
    
    public static void main(String[] args) {      
        int anz = 10000;
        int max = 500000;
        MeinZahlenarray array= new MeinZahlenarray(anz, max);
        
        int anzahl= ZahlenPruefer.anzahlVerschiedene(array);
        System.out.println("Anzahl: "+anzahl);
        String mircoseconds = " �s";
        System.out.println("istEnthalten verbraucht durchschnittlich "
                +1000*array.getDurchschnittlicheAbfragezeit()+mircoseconds);
        System.out.println("istEnthaltenTest verbraucht durchschnittlich "
                +1000*array.getDurchschnittlicheAbfragezeitTest()+mircoseconds);
    }
}

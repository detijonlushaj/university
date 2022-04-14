package de.hsh.fakturierung;

import de.hsh.fakturierung.rechnung.Rechnung;
//import de.hsh.fakturierung.rechnung.Rechnungsposition;

public class Main {

    public static void main(String[] args) {
        Rechnung r1 = new Rechnung(1);
        r1.addPos(123, 5.50);
        r1.addPos(55, 2);
        r1.addPos(3, 10);
        
        //Rechnungsposition r3 = new Rechnungsposition(1, 2); DAS GEHT NICHT, not visible
        System.out.println(r1.getArtikelnummer(0) + ": " + r1.getPreis(0));
        System.out.println(r1.getArtikelnummer(1) + ": " + r1.getPreis(1));
        System.out.println(r1.getArtikelnummer(2) + ": " + r1.getPreis(2));

    }

}

package de.hsh.fakturierung.rechnung;

public class Rechnungsposition {
    private int artikelnummer;
    private double preis;
    
    Rechnungsposition(int artikelnummer, double preis) {
        this.artikelnummer = artikelnummer;
        this.preis = preis;
    }
    
    int getArtikelnummer() {
        return artikelnummer;
    }
    
    double getPreis() {
        return preis;
    }

}

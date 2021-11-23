public class Bankkonto {
    private int kontostand;
    private int nr;
    private static int nrN = 0;
   
    public Bankkonto() {
        kontostand= 0;
        nrN++;
        this.nr= nrN;
    }
    
    public static int getAnzahlKonto() {
        return nrN;
    }
}
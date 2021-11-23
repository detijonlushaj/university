public class Raten {
    public static void main(String[] args) {
        int wert= -1;
        long start, stop;
        final int MAX= 1000000000;
        
        System.out.println("Brute Force Version:");
        start= System.currentTimeMillis();
        wert= ratenIterativ(MAX);
        stop= System.currentTimeMillis();
        System.out.println("Zahlenkombination ist: " + wert);
        System.out.println("Dauer: " + (stop-start)/1000.0 + "s");
        System.out.println("Anfragen: " + Ratespiel.anfragen());
        System.out.println();

        System.out.println("Rekursive Version:");
        start= System.currentTimeMillis();
        wert= ratenRekursiv(0, MAX);
        stop= System.currentTimeMillis();
        System.out.println("Zahlenkombination ist: " + wert);
        System.out.println("Dauer: " + (stop-start)/1000.0 + "s");
        System.out.println("Anfragen: " + Ratespiel.anfragen());
    }
    
    public static int ratenIterativ(int max) {
        for (int i=0; i<max; i++) {
            if (Ratespiel.rate(i)) {
                return i;
            }
        }
        return -1;
    }
    
    public static int ratenRekursiv(int min, int max) {
        int vermutung= (min+max)/2;
        if (Ratespiel.istGroesserAls(vermutung)) {
            return ratenRekursiv(vermutung+1, max);
        }
        if (Ratespiel.rate(vermutung)) {
            return vermutung;
        }
        return ratenRekursiv(min, vermutung-1);
    }
}
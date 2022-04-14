/**
 * Bruchklasse
 * @author lushaj
 *
 */
public class Bruch {
    private int zaehler;
    private int nenner;
    /**
     * Bruchklasse
     */
    public Bruch(int zaehler2,int nenner2) {
        setZaehler(zaehler2);
        setNenner(nenner2);
    }
    /**
     *
     */
    public void setZaehler(int zaehler1) {
        this.zaehler = zaehler1;
    }
    /**
     * 
     */
    public void setNenner(int nenner1) {
        if ( nenner1 != 0) {
            this.nenner = nenner1;
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * 
     */
    public int getZaehler() {
        return this.zaehler;
    }
    /**
     * 
     */
    public int getNenner() {
        return this.nenner;
    }
    /**
     * 
     */
    @Override public int hashCode() { 
        int ggt = Math.abs(ggt(zaehler,nenner));

        if (nenner < 0 ) {
            ggt= -ggt;
        }
        return java.util.Objects.hash(zaehler/ggt,nenner/ggt);
    }
    /**
     * 
     */
    @Override public boolean equals(Object o) {
        if (o instanceof Bruch ) {
            Bruch temp = (Bruch) o; // cast and compare it
            return temp.hashCode() == this.hashCode(); 
        } else {
            return false;
        }
    }
    /**
     * 
     */
    public int ggt(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}

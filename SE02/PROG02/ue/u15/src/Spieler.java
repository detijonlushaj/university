/**
 * 
 * Gruppe 03
 * @author lushaj
 * U15 Klasse mit Objektz�hler
 *
 */
public class Spieler {
    private String name;
    private int backNumber;
    private static int backNumberN = 0;
    
    /**
     * constructor
     * @param name
     */
    public Spieler (String name) {
        this.name = name;
        backNumber = setBackNumber();
    }
    
    /**
     * toString
     */
    public String toString() {
        return name + " (" + backNumber + ")";
    }
    
    /**
     * 
     * @return next back number
     * @throw illegalStateException if backNumberN >= 11 so when more than 11 instances
     * were already created
     */
    public static int setBackNumber() {
        if (backNumberN >= 11) {
            throw new IllegalStateException("Mehr als 11 Spieler sind verboten!");
        }
        backNumberN++;
        return backNumberN;
    }
    
}

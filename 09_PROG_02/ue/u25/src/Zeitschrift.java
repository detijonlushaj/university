/**
 * @author lushaj
 */
public class Zeitschrift extends Medium {
    private int nummer;
    private int conNummer = 1;
    
    /**
     * constructor
     * @param titel
     * @param jahr
     * @param monat
     */
    public Zeitschrift(String titel, int jahr, int nummer) {
        setTitel(titel);
        setErscheinungsjahr(jahr);
        setNummer(nummer);
    }
    
    /**
     * @return toString of instance
     */
    @Override public String toString() {
        return getTitel() + " (" + nummer + "/" + getErscheinungsjahr() + ")";
    }
    
    /**
     * @return int nummer
     */
    public int getNummer() {
        return nummer;
    }
    
    /**
     * @param nummer
     */
    public void setNummer(int nummer) {
        this.nummer = checkInt(nummer, conNummer);
    }
    
    /**
     * @return int Leihfrist
     */
    @Override public int getLeihFrist() {
        return 7;
    }
}

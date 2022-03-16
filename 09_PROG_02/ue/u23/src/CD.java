/**
 * @author lushaj
 */
public class CD extends Medium {
    private String kuenstler;
    private int length;
    private int conLength = 1;
    
    /**
     * constructor
     * @param title
     * @param jahr
     * @param autor
     * @param length
     */
    public CD(String titel, int jahr, String kuenstler, int length) {
        setTitel(titel);
        setErscheinungsjahr(jahr);
        setKuenstler(kuenstler);
        setGesamtspielzeit(length);
    }
    
    /**
     * @return toString of instance
     */
    @Override public String toString() {
        return kuenstler + ": " + getTitel() + " (" + getErscheinungsjahr() + ") " + length + " Minuten"; 
    }
    
    /**
     * @return String kuenstler
     */
    public String getKuenstler() {
        return kuenstler;
    }
    
    /**
     * @param kuenstler
     */
    public void setKuenstler(String kuenstler) {
        this.kuenstler = checkString(kuenstler, "K�nstler");
    }
    
    /**
     * @return int length
     */
    public int getGesamtspielzeit () {
        return length;
    }
    
    /**
     * @param length
     */
    public void setGesamtspielzeit(int length) {
        this.length = checkInt(length, conLength);
    }
    
    /**
     * @return int Leihfrist
     */
    @Override public int getLeihFrist() {
        return 14;
    }
}

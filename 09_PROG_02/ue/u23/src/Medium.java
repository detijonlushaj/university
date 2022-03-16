/**
 * @author lushaj
 */
public abstract class Medium implements Comparable<Medium> {
    private int jahr;
    private String titel;
    private int conJahr = 0;
    
    @Override public int compareTo(Medium other) {
        return Integer.valueOf(jahr).compareTo((Integer)other.getErscheinungsjahr());
    }
    
    /**
     * constructor
     * @param s
     * @param object
     * @return
     */
    @SuppressWarnings("unused")
    protected String checkString(String s, String object) {
        if (s == null) {
            throw new IllegalArgumentException(object + " ist nicht definiert");
        } else if (s.equals("")) {
            throw new IllegalArgumentException(object + " ist leer");
        }
        return s;
    }
    
    /**
     * 
     * @param i
     * @param condition
     * @return int
     * @throws IllegalArgumentException when i smaller than condition
     */
    protected int checkInt(int i, int condition) {
        if (i < condition) {
            throw new IllegalArgumentException(i + " muss gr��er als " + condition + " sein");
        }
        return i;
    }
    
    /**
     * @return String titel
     */
    public String getTitel() {
        return titel;
    }
    
    /**
     * @param titel
     */
    public void setTitel(String titel) {
        this.titel = checkString(titel, "Titel");
    }
    
    /**
     * @return int jahr
     */
    public int getErscheinungsjahr() {
        return jahr;
    }
   
    /**
     * @param jahr
     */
    public void setErscheinungsjahr(int jahr) {
        this.jahr = checkInt(jahr, conJahr);
    }
    
    /**
     * @return int Leihfrist
     */
    public abstract int getLeihFrist();
}

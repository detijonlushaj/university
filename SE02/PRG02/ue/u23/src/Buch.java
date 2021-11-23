/**
 * @author lushaj
 */
public class Buch extends Medium {
    private String verlag, autor;
    
    /**
     * constructor
     * @param title
     * @param jahr
     * @param verlag
     * @param autor
     */
    public Buch(String titel, int jahr, String verlag, String autor) {
        setTitel(titel);
        setErscheinungsjahr(jahr);
        setVerlag(verlag);
        setAutor(autor);
    }
    
    /**
     * @return toString of instance
     */
    @Override public String toString() {
        return autor + ": " + getTitel() + " (" + getErscheinungsjahr() + ") " + verlag;
    }
    
    /**
     * @return String verlag
     */
    public String getVerlag() {
        return verlag;
    }
    
    /**
     * @param verlag
     */
    public void setVerlag(String verlag) {
        this.verlag = checkString(verlag, "Verlag");
    }
    
    /**
     * @return String autor
     */
    public String getAutor() {
        return autor;    
    }
    
    /**
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = checkString(autor, "Autor");
    }
    
    /** 
     * @return int Leihfrist
     */
    @Override public int getLeihFrist() {
        return 28;
    }
    
}

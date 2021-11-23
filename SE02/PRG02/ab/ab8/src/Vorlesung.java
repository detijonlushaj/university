public class Vorlesung {
    private String titel;
    private int sws;

    public Vorlesung(String titel, int sws) {
        this.titel = titel;
        this.sws = sws;
    }
    
    @Override
    public String toString() {
        return this.titel + "(" + sws + ")";
    }
    
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vorlesung) {
            Vorlesung v = (Vorlesung) other;
            if (titel != null) {
                return v.titel != null && titel.equals(v.titel) && sws == v.sws; 
            } else {
                return v.titel == null && sws == v.sws;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(titel, sws);
    }

}
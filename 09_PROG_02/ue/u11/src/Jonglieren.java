/**
 * Gruppe 03
 * @author lushaj
 * U11
 */
public class Jonglieren extends Ballspiel {
    
    /**
     * Anzahl Mannschaften
     */
    @Override public int getMannschaften() {
        return 1;
    }
    
    /**
     * Anzahl B�lle
     */
    @Override public int getBaelle() {
        return 5;
    }
    
    /**
     * 
     * @return lernRegel
     */
    public String lernRegel() {
        return "�ben, �ben, �ben";
    }
}

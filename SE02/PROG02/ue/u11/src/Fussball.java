/**
 * Gruppe 03
 * @author lushaj
 * U11
 */
public class Fussball extends Ballspiel{
    
    /**
     * return Spieldauer
     */
    
    @Override public int getSpieldauer() {
        return 90;
    }
    
    /**
     * 
     * @return Einwurfregel
     */
    public String einwurfRegel() {
        return "Handspiel erlaubt";
    }
    
    /**
     * 
     * @return Eckregel
     */
    public String eckRegel() {
        return "Mindestabstand anderer Spieler 9,15 m";
    }
}

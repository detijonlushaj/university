/**
 * Gruppe 03
 * @author lushaj
 * U11
 */
public class BeachSoccer extends Fussball {
    
    /**
     * return Spieldauer
     */
    @Override public int getSpieldauer() {
        return 36;
    }
    
    /**
     * return Einwurfregel
     */
    @Override public String einwurfRegel() {
        return "Maximal 5 Sekunden";
    }
    
    /**
     * return Eckregel
     */
    @Override public String eckRegel() {
        return "Maximal 5 Sekunden";
    }
}

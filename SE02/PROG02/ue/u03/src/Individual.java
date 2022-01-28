/**
 * 
 * Gruppe 03
 * @author lushaj
 *
 */
public class Individual {
    String givenName;
    String familyName;
    
    
    /**
     * 
     * @return name as String
     */
    public String getFull() {
        return givenName + " " + familyName;
    }
    
    public String getRev() {
        return familyName + "; " + givenName;
    }
}

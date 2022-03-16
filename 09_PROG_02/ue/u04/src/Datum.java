/**
 * Gruppe 03
 * @author lushaj
 * U04
 */
public class Datum {
    int tag;
    int monat; 
    int jahr;
    String pad4 = "%04d";
    String pad2 = "%02d";
    String zero = ".";
    String slash = "/";
    
    /**
     * 
     * @return ob Schaltjahr
     */
    public boolean istSchaltjahr() {
        return jahr % 400 == 0 || jahr % 4 == 0 && jahr % 100 != 0;
    }
    
    /**
     * 
     * @return deutsches Datum
     */
    public String getDeutscheSchreibung() {
        return tag + zero + String.format(pad2, monat) + zero + String.format(pad4, jahr);
    }
    
    /**
     * 
     * @return amerikanisches Datum
     */
    public String getAmerikanischeSchreibung() {
        return String.format(pad2, monat) + slash + tag + slash + String.format(pad4, jahr);
    }
    
    /**
     * �ndert Datum auf den n�chsten Tag ab
     */
    public void setMorgen() {
        if (monat == 2) {
            if (istSchaltjahr() && tag == 29) {
                tag = 1;
                monat++;
            } else if (!istSchaltjahr() && tag == 28) {
                tag = 1;
                monat++;
            } else {
                tag++;
            }
            return;
        }
        
        if (tag < 30) {
            tag++;
        } else if (tag == 31) {
            if (monat != 12) {
                tag = 1;
                monat++;
            } else {
                tag = 1;
                monat = 1; 
                jahr++;
            }
        } else {
            if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat ==  8 || monat == 10 || monat == 12) {
                tag++;
            } else {
                tag = 1;
                monat++;
            }
        }
    }
}
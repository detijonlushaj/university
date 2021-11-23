package de.hsh.prog.v05.javadoctest;

/**
 * Speichert eine Adresse bestehend aus: 
 * <ul>
 *  <li>Strasse inkl. Hausnummer,</li>
 *  <li>Postleitzahl (5-stellig),</li>
 *  <li>Ort (Kurzform bei langen Ortsnamen).</li>
 * </ul>
 * @author garmann
 */
public class Adresse {

    /**
     * Strasse inkl. Hausnummer
     */
    private String strasse;
    
    /**
     * Ort. Bei langen Ortsnamen wie
     * "Pfaffenschlag bei Waidhofen an der Thaya" 
     * wird nur eine Kurzform (z. B. "Pfaffenschlag") 
     * gespeichert.
     */
    private String ort;

    /**
     * Postleitzahl, 5-stellig
     */
    int plz;

    /**
     * Anlegen einer Adresse.
     * @param strasse Strasse inkl. Hausnummer
     * @param ort Ort. Lange Ortsnamen wie
     *   "Pfaffenschlag bei Waidhofen an der Thaya" 
     *   sollen als Kurzform (z. B. "Pfaffenschlag") 
     *   übergeben werden.
     * @param plz Postleitzahl. Es muss gelten {@code 0 <= plz <= 99999}.
     * @exception IllegalArgumentException falls einer der Parameter ungültig ist.
     */
    public Adresse(String strasse, String ort, int plz) {
        this.strasse = strasse;
        this.ort = ort;
        this.plz = plz;
    }

    /**
     * Liefert die Strasse
     * @return Strasse inkl. Hausnummer
     */
    public String getStrasse() {
        return strasse;
    }
    
    /**
     * Setzt die Strasse. <code>null</code> und leere Strasse sind nicht erlaubt.
     * @param strasse neue Strasse inkl. Hausnummer
     * @exception IllegalArgumentException falls der Parameter den Wert <code>null</code> hat
     * oder leer ist.
     */
    public void setStrasse(String strasse) {
        if (strasse == null || strasse.equals("")) {
            throw new IllegalArgumentException("Strasse fehlt");
        }
        this.strasse = strasse;
    }
    
    /**
     * Liefert den Ort
     * @return Ort. Bei langen Ortsnamen wie
     *   "Pfaffenschlag bei Waidhofen an der Thaya" 
     *   wird nur eine Kurzform (z. B. "Pfaffenschlag") 
     *   geliefert.
     */
    public String getOrt() {
        return ort;
    }
    /**
     * Setzt den Ort. <code>null</code> und leerer Ort sind nicht erlaubt.
     * @param ort neuer Ort. Lange Ortsnamen wie
     *   "Pfaffenschlag bei Waidhofen an der Thaya" 
     *   sollen als Kurzform (z. B. "Pfaffenschlag") 
     *   übergeben werden.
     * @exception IllegalArgumentException falls der Parameter den Wert <code>null</code> hat
     *   oder leer ist.
     */
    public void setOrt(String ort) {
        if (ort == null || ort.equals("")) {
            throw new IllegalArgumentException("Ort fehlt");
        }
        this.ort = ort;
    }
    
    /**
     * Liefert die Postleitzahl
     * @return Postleitzahl, maximal 5-stellig
     */
    public int getPlz() {
        return plz;
    }
    /**
     * Setzt die Postleitzahl. 
     * @param plz neue Postleitzahl. Es muss gelten {@code 0 <= plz <= 99999}. 
     * @exception IllegalArgumentException falls die Postleitzahl ungültig ist.
     */
    public void setPlz(int plz) {
        if (plz < 0 || plz > 99999) {
            throw new IllegalArgumentException("Falsche Postleitzahl");
        }
        this.plz = plz;
    }
}

package de.hsh.prog.v05.javadoctest;
/**
* <p>Die Klasse <code>Patient</code> speichert Patientennamen und eine 
* {@link Adresse}.</p>
* 
* <p>Ein Patient ist eine Person, die an 
* einer Krankheit oder an den Folgen eines Unfalls leidet und 
* deshalb medizinisch behandelt wird.</p>
* 
* @see <a href="http://de.wikipedia.org/wiki/Patient">Wikipedia-Artikel</a>
* @see Adresse
*/
public class Patient {
    
    /**
     * Name des Patienten
     */
    private String name;
    
    /**
     * Adresse des Patienten
     */
    private Adresse adresse;
    
    /**
     * Initialisiert den Patienten mit einem Namen. 
     * @param name Name des Patienten
     * @exception IllegalArgumentException falls der Parameter den Wert <code>null</code> hat
     * oder leer ist.
     */
    public Patient(String name) {
        setName(name);
    }
    
    /**
    * Legt den Namen mit Hilfe des Parameters <code>n</code> vom Typ {@link String} fest.
    * @param n Nachname der Person
    * @exception IllegalArgumentException falls der Parameter den Wert <code>null</code> hat
    * oder leer ist.
    */
    public void setName(String n)  {
        if (n == null || n.equals("")) {
            throw new IllegalArgumentException("Name fehlt");
        }
        name = n;
    }

    /**
    * Liefert den Namen, der mit der Methode {@link #setName setName} gesetzt wurde.
    * Ein leerer Name ist erlaubt.
    * @return Nachname der Person
    */
    public String getName() {
        return name;
    }
    
    /**
     * Ersetzt die Adresse durch eine neue.
     * @param a neue Adresse. Der Wert <code>null</code> ist erlaubt.
     */
    public void setAdresse(Adresse a) {
        adresse= a;
    }
    
    /**
     * Liefert die Adresse des Patienten
     * @return Adress-Objekt (oder <code>null</code>, falls noch nicht gesetzt)
     */
    public Adresse getAdresse() {
        return adresse;
    }
}

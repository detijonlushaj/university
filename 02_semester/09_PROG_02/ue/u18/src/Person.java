import java.io.Serializable;

/**
 * @author lushaj
 *  Person mit Name und Referenz auf den besten Freund.
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Person bestFriend;
    /**
     * Anlegen einer Person
     * @param name Name der Person
     */
    public Person(String name) {
        this.name = name;
    }
    /**
     * Initialisiert den besten Freund
     * @param friend bester Freund
     */
    public void setBestFriend(Person friend) {
        this.bestFriend= friend;
    }
    /**
     * @return bester Freund der Person
     */
    public Person getBestFriend() {
        return bestFriend;
    }
    /**
     * @return Name der Person
     */
    public String getName() {
        return name;
    }
    /**
     * @return Name gefolgt vom Namen des besten Freundes. Z. B. "Hans (Frieda)".
     */
    @Override public String toString() {
        return name + " (" + bestFriend.name+ ")";
    }
}
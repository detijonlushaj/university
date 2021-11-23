import java.util.ArrayList;

/**
 * client program
 * @author lushaj
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Spieler> spieler = new ArrayList();
        
        for (int i = 0; i < 11; i++) {
            spieler.add(new Spieler("A"));
        }
        System.out.println(spieler.toString());
        
        spieler.add(new Spieler("F"));
    }

}

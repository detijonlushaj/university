import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Spieler> list= new ArrayList<Spieler>();
        Spieler s;
        s= new Spieler();  s.name="Müller";   s.nummer= 7;   list.add(s);
        s= new Spieler();  s.name="Meier";    s.nummer= 6;   list.add(s);
        s= new Spieler();  s.name="Schulze";  s.nummer= 14;  list.add(s);
        System.out.println(list);
    }

}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Client {

    public static void main(String[] args) {

        // Client
        ArrayList<Person> list= new ArrayList<Person>();
        Collections.addAll(list, 
                new Person("Frieda", 41), new Person("Gerd", 44),
                new Person("Mona", 23), new Person("Albert", 43));
        System.out.println(list);

        // TODO: sortieren mit anonymer Comparator-Subklasse

        Comparator<Person> cmp = new Comparator<Person>() {
            @Override
            public int compare (Person a, Person b) {
                return Integer.compare(b.getAlter(), a.getAlter()); // sort descending
                // oder: return - Integer.compare(a.getAlter(), b.getAlter());
            }
        };


        Collections.sort(list, cmp);

        System.out.println(list);

    }

}

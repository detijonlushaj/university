import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 * Gruppe 03
 * @author lushaj
 * U18 Serialisierung
 */
public class Decode {
    /**
     * Deserialisierung einer dat Datei
     * @param path
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @SuppressWarnings("resource")
    public static void decode(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object ob = ois.readObject();
        @SuppressWarnings("unchecked")
        ArrayList<Person> arr = (ArrayList<Person>)ob;
        
        for (Person p : arr) {
            System.out.println(p.getName() + " mag " + p.getBestFriend().getName());
        }
    }

    /**
     * client code
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        decode("friends.dat");
    }
}

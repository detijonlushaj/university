/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U30 Elemente doppeln*/
import java.util.ArrayList;
import java.util.Collections;
public class Verdoppeln {
    /** main Methode*/
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        Collections.addAll(array, "Ich", "studiere", "in", "Hannover");
        System.out.println(array.toString());
        verdoppeln(array);
    }
    
    /** *Parameter: ArrayList
        *returns: - */
    public static void verdoppeln(ArrayList<String> array) {
        int len = array.size();
        for (int i = 0; i < len; i++) {
            array.add("");
        }
        
        for (int i = (array.size() / 2) -1; i >= 0; i--) {
            if (i >= 1) {
                array.set(2*i, array.get(i));
                array.set(2*i + 1, array.get(i));
            } else {
                array.set(1, array.get(0));
            }
        }
        System.out.println(array.toString());
    }
}
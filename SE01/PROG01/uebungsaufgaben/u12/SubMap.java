/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U31 Teil-Map*/
import java.util.HashMap;
import java.util.Iterator;
public class SubMap {
    /** main Methode */
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();
        map1.put("Meier", "0511-673904");
        map1.put("Müller", "030-8497489");
        map2.put("Meier", "0511-673904");
        map2.put("Schulz", "0511-673904");
        map2.put("Müller", "030-8497489");
        map2.put("Schmidt", "040-1994533");
        System.out.print(subMap(map1, map2));
    }
    
    /** *Parameter: 2 HashMap<String, String>
        returns: boolean if para.1 is submap of para.2
    */
    public static boolean subMap(HashMap<String, String> map1, HashMap<String, String> map2) {
        if (map1.size() > map2.size()) {
            return false;
        }
        
        int num = 0;
        
        for (String n : map1.keySet()) {
            if (map2.containsKey(n)) {
                if (map1.get(n).equals(map2.get(n))) {
                    num++;
                } else {
                    return false;
                }
            }
        }
        return num == map1.size();
    }
}
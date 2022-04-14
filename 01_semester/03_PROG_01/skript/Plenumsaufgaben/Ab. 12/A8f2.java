import java.util.HashMap;
import java.util.Scanner;
import java.util.Iterator;
import java.io.*;
public class A8f2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("song.txt"));
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        String word = null;
        while (true) {
            if (!input.hasNext()) {
                break;
            }
            word = input.next();
            if (!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                map.put(word, map.get(word) + 1);
            }
        }
        input.close();
        
        Iterator<String> itr = map.keySet().iterator();
        while(itr.hasNext()) {
            word = itr.next();
            System.out.println(word + ": " + map.get(word));
        }
    }
}
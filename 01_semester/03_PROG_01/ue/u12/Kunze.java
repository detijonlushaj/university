/** *Abgabeteam 03
    *Aydin, Lushaj, Abdel Kader
    *U32 Bauer Kunze*/
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Arrays;
public class Kunze {
    /** main Methode*/
    public static void main(String[] args) {
        printl("<0> Statistik erstellen und Programmende");
        printl("<1> Beerenmix Fruchtaufstrich 200ml");
        printl("<2> Pflaume Holunder Fruchtaufstrich 200 ml");
        printl("<3> Sauerkirsche Fruchtaufstrich");
        printl("<4> Apfel Birnen Saft 1l");
        printl("<5> Apfel Schorle 1l");
        printl("<6> Apfelsaft Familienpackung 10l");
        printl("<7> Brotzeitbrett Kunze");
        printl("");
        
        askUser();
    }
    
    /** *Para: -
        *returns: -
        * Aufforderung des users zur Eingabe*/
    public static void askUser() {
        Scanner console = new Scanner(System.in);
        TreeMap<Integer, TreeMap<Double, Integer>> map = new TreeMap<>();
        while (true) {// as long as product not 0
            print("Ihre Wahl? ");
            int product = console.nextInt();
            if (product == 0) {
                printl("Statistik (in der obigen Sortierung)");
                printl("");
                break;
            }
            print("Zu welchem Preis? ");
            double price = console.nextDouble();
            print("Wie viele Einheiten? ");
            int units = console.nextInt();
            if (!map.containsKey(product)) {
                TreeMap<Double, Integer> map2 = new TreeMap<>();
                map.put(product, map2);
                map.get(product).put(price, units);
            } else {
                if (!map.get(product).containsKey(price)) {
                    map.get(product).put(price, units);
                } else {
                    map.get(product).put(price, map.get(product).get(price) + units);
                }
            }
            printl("");
        }
        calculate(map);
    }
    
    /** *Para: TreeMap<Integer, TreeMap<Double, Integer>>
        *returns: -
        *Kalkulationen für die Statistik erstellen*/
    public static void calculate(TreeMap<Integer, TreeMap<Double, Integer>> map) {
        for (Integer i : map.keySet()) {
            if (i == 1) {
                printl(preText() + "Beerenmix Fruchtaufstrich 200ml");
            } else if (i == 2) {
                printl(preText() + "Pflaume Holunder Fruchtaufstrich 200 ml");
            } else if (i == 3) {
                printl(preText() + "Sauerkirsche Fruchtaufstrich");
            } else if (i == 4) {
                printl(preText() + "Apfel Birnen Saft 1l");
            } else if (i == 5) {
                printl(preText() + "Apfel Schorle 1l");
            } else if (i == 6) {
                printl(preText() + "Apfelsaft Familienpackung 10l");
            } else if (i == 7) {
                printl(preText() + "Brotzeitbrett Kunze");
            }
            printl("  Einzelverkäufe (nach Preis aufsteigend sortiert):");
            for (Double d : map.get(i).keySet()) {
                printl("    " + map.get(i).get(d) + " Einheiten zu " + d + " EUR");
            }
            printl("  Akkumulierte Werte:");
            int units = 0; 
            double sum = 0;
            double price = 0;
            for (Double d : map.get(i).keySet()) {
                units += map.get(i).get(d);
                sum += d * map.get(i).get(d);
            }
            double priceAverage = round2((double) (sum / units));
            printl("    Einheiten (gesamt): " + units);
            printl("    Durchschnittspreis: " + priceAverage + " EUR");
            printl("");
        }
    }
    
    /** *Para: -
        *returns: String
        *Häufig genutze Zeichenkette */
    public static String preText() {
        return "Statistik für ";
    }
    
    /** *Para: double
        *retuns: double*/
    public static double round2(double value) {
        if (Double.isNaN(value)) return value;
        if (Double.isInfinite(value)) return value;
        return Math.round(value * 100) / 100.0;
    }
    
    /** *Para: String
        *retuns: -
        *System.out.print vermeiden*/
    public static void print(String s) {
        System.out.print(s);
    }
    
    /** *Para: String
        *retuns: -
        *System.out.println vermeiden*/
    public static void printl(String s) {
        System.out.println(s);
    }
}
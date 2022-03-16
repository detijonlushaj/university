import java.util.ArrayList;
import java.util.Scanner;
public class A8av {
    public static void main(String[] args) {
      Scanner console= new Scanner(System.in);
      ArrayList<String> liste = new ArrayList<String>();
    
      for (int i=0; i<10; i++) {
        String eingabe= console.nextLine();
        liste.add(eingabe); 
      }
    
      int summe= 0;
      for (String s : liste) {
        summe = summe + s.length(); 
      }
      System.out.println("Gesamtlänge: "+summe);
    }
}
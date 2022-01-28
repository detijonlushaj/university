import java.io.*;
import java.util.Scanner;
public class Auf_6di {
    public static void main(String[] args) throws FileNotFoundException{
        File f = new File("Quote.txt");
        Scanner input = new Scanner(f);
        
        while (input.hasNextLine()) {
            System.out.println("> " + input.nextLine());
        }
        input.close();
    }
}
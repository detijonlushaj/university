import java.io.*;
import java.util.Scanner;
public class Auf_6fi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Input.txt"));
        PrintStream output = new PrintStream(new File("Output.txt"));
        
        echoUpper(input, output);
        output.close();
        input.close();
    }
    
    public static void echoUpper(Scanner input, PrintStream output) {
        while (input.hasNextLine()) {
            String inputString = input.nextLine();
            output.println(" < " + inputString.toUpperCase());
        }
    }
}

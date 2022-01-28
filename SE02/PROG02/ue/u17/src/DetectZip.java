import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Gruppe 03
 * @author lushaj
 * U17 Streams
 */
public class DetectZip {

    public static void main(String[] args) throws IOException {
        String error = "error";
        if (args.length != 1) {
            System.out.println(error);
            return;
        }
        
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Bla");
        }
        
        String a = null;
        String b = null; 
        try {
            a = Integer.toHexString(fis.read());
            b = Integer.toHexString(fis.read());
        } catch(IOException e) {
            throw new IOException("bla");
        } finally {
            fis.close();
        }
        
        if (!a.equals("50") || !b.equals("4b")) {
            System.out.println("no zip");
            return;
        }
        System.out.println("zip");
    }

}

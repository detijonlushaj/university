import java.io.*;
public class A7fi {
    public static void main(String[] args) {
        File[] files= listFiles(args[0]);
        for (int i=0; i < files.length; i++) {
            File f= files[i];
            System.out.print(f.getName());
            if (f.isDirectory()) {
                System.out.println(" (directory)");
            } else {
                System.out.println(" (" + f.length() + " bytes)");
            }
        }
    }
    
    public static File[] listFiles(String pathName) {
        File path = new File(pathName);
        String[] elements = path.list(); 
        
        File[] results = new File[elements.length];
        for (int i = 0; i < elements.length; i++) {
            results[i] = new File(pathName + "/" + elements[i]);
        }
        return results;
    }
}
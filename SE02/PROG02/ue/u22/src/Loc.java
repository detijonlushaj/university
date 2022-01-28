import java.nio.file.*;
import java.io.*;
import java.time.*;

class Log {
    private Path p;
    public Log(String file) {
        this.p= new File(file).toPath();
        try {
            Files.deleteIfExists(p);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void log(String text) {
        try {
            Files.write(p, (LocalDateTime.now()+": "+text+"\n").getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.bjp.DrawingPanel;

public class Sender {

    public static void main(String[] args) throws FileNotFoundException {
        Station station = erzeugeStation();
        Graphics g = erzeugeZeichenbereich();
        station.draw(g);
        staedteLesenUndZeichnen(station, g);
    }
    
    public static Station erzeugeStation() {
        @SuppressWarnings("resource")
        Scanner console = new Scanner(System.in);
        System.out.print("Sender x? ");
        int senderx = console.nextInt();
        System.out.print("Sender y? ");
        int sendery = console.nextInt();
        System.out.print("Radius? ");
        int radius = console.nextInt();
        return new Station(senderx, sendery, radius);
    }
    
    public static Graphics erzeugeZeichenbereich() {
        DrawingPanel panel = new DrawingPanel(200, 200);
        return panel.getGraphics();
    }
    
    public static void staedteLesenUndZeichnen(Station station, Graphics g) throws FileNotFoundException {
            Scanner input = new Scanner(new File("cities.txt"));
            int numCities = input.nextInt(); // first line = # of cities
            for (int i = 0; i < numCities; i++) {
                Loc city= new Loc(input.nextInt(), input.nextInt());
                station.drawReceiver(g, city);
            }
            input.close();
    }
}
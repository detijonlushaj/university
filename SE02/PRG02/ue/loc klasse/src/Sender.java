import com.bjp.DrawingPanel;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Sender {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("Cities.txt"));

		Loc[] cities = readCities(input);
		input.close();

		DrawingPanel panel= new DrawingPanel(200, 200); 
		Graphics g= panel.getGraphics();

		drawCities(cities,g);

		Scanner console = new Scanner(System.in) ;
		Loc sender = new Loc();
		System.out.print("Sender x?");
		int x = console.nextInt();
		System.out.print("Sender y?");
		int y= console.nextInt();
		sender.setLocation(x, y);
		System.out.print("Radius?");
		int r = console.nextInt();
		console.close();

		check(sender , r, cities,g);
		
		for (int i =0; i< cities.length;i++) {
			System.out.println("Stadt " + i + ": "+ cities[i].toString());
		}

	}
	public static void  check(Loc sender, int r, Loc[] cities , Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawOval(sender.getX() - r, sender.getY() -r , r*2, r*2);
		for (int i =0 ; i< cities.length; i++) {		
			//int dx = cities[i].x - sender.x;
			//int dy = cities[i].y - sender.y;
			double distance = cities[i].distance(sender);//Math.sqrt(dx * dx + dy * dy);

			if (distance <= r) {
				cities[i].draw(g, 3);
			}
		}
	}

	public static void drawCities(Loc[] cities, Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < cities.length;i++) {
			cities[i].draw(g, 3);

		}	
	}	

	public static Loc[] readCities(Scanner input) {
		int num = input.nextInt();
		Loc[] cities = new Loc[num];
		for (int i = 0; i<num; i++) {
			Loc loc = new Loc();
			//Loc loc = new Loc(input.next(), input.next());
			//loc.setLocation(input.next(), input.next());
			int x = input.nextInt();
			int y = input.nextInt();
			loc.setLocation(x, y);
			cities[i] = loc;	
		}
		return cities;
	}
}
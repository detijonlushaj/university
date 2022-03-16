import java.util.Scanner;

public class AktieMain {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.print("ISIN der ersten Aktie:");
		String name1 = input.next();
		Aktie a1 = new Aktie(name1);
		double gewinn1 = taetigeKaeufe(input,a1);
		
		System.out.print("ISIN der zweiten Aktie:");
		String name2 = input.next();
		Aktie a2 = new Aktie(name2);
		double gewinn2 = taetigeKaeufe(input,a2);
		
		if( gewinn2 < gewinn1) {
			System.out.println(a1.getisin()+" war rentabler als "+ a2.getisin());
		} else if(gewinn1 < gewinn2) {
			System.out.println(a2.getisin()+" war rentabler als "+ a1.getisin());
		} else {
			System.out.println(a1.getisin() + " und " + a2.getisin() + " waren gleich rentabel.");
		}
	}

	public static double  taetigeKaeufe(Scanner input, Aktie a) {
		System.out.print("Wie viele Käufe haben Sie getätigt?");
		int n = input.nextInt();

		for(int i = 0; i < n ; i++) {
			System.out.print( i+1 +": Wieviele Aktien zu welchem Kaufkurs?");
			int anzahl = input.nextInt();
			double kaufKurs = input.nextDouble();
			a.kaufe( anzahl,kaufKurs);
		}

		System.out.print("Zu welchem Kurs notiert die Aktie heute?");
		double heute = input.nextDouble();
		double gewinn = a.getGewinn(heute);
		System.out.println("Nettogewinn/-verlust: " + gewinn);
		System.out.println();
		return gewinn;


	}
}
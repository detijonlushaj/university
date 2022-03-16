
public class Aktie {

	private String isin;
	private int gesamtAnzahl;
	private double gesamtKosten;

	public Aktie(String name) {
		if (name == null) {
			throw new NullPointerException("isin darf nicht null sein");
		} else {
			this.isin = name;
		}
	}

	public String getisin() {
		return isin;
	}

	public void kaufe(int anzahl, double kaufKurs) {
		if (kaufKurs < 0) {
			throw new IllegalArgumentException("kaufKurs muss >= 0 sein");
		}
		if (anzahl < 0) {
			throw new IllegalArgumentException("anzahl muss >= 0 sein"); 
		}
		gesamtAnzahl += anzahl;
		gesamtKosten += anzahl * kaufKurs;
	}

	public double getGewinn(double aktuellerKurs) { 
		if (aktuellerKurs < 0) {
			throw new IllegalArgumentException("aktuellerKurs muss "+ ">= 0 sein");
		}
		double marktWert= gesamtAnzahl * aktuellerKurs;
		return marktWert - gesamtKosten; 
	}

}

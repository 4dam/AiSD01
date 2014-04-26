public class Student {

	public Student(String nazwisko,	String imie, String dataUrodzenia, long nrAlbumu, int rokStudiow, double srednia) {
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.dataUrodzenia = dataUrodzenia;
		this.nrAlbumu = nrAlbumu;
		this.rokStudiow = rokStudiow;
		this.srednia = srednia;
	}
	
	String nazwisko;
	String imie;
	String dataUrodzenia;
	long nrAlbumu;
	int rokStudiow;
	double srednia;
	
	public String toString() {
		return nazwisko + " " + imie + " " + dataUrodzenia + " " + nrAlbumu + " " + rokStudiow + " " + srednia; 
	}
}
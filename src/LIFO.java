
public class LIFO extends Kolejka {

	
	public void dodaj(Student s) {
		stud.insert(0, s);
	}
	
	
	public void usun() {
		stud.usunPierwszy();
	}
	
	public Student dajPierwszego() {
		return stud.zwroc1(0);
	}
	
	
}

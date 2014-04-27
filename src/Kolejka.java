import java.util.Iterator;

		//FIFO wg dodania
public class Kolejka implements Iterable<Student> {

	Lista stud = new Lista();
	
	public void dodaj(Student s) {
		stud.dodajNaKoniec(s);
	}
	
	public void usun() {
		stud.usunPierwszy();
	}

	public boolean czyPusta() {
		return stud.lens() == 0;
	}
	
	public Student dajPierwszego() {
		return stud.zwroc1(0);
	}
	
	public Iterator<Student> iterator() {
		return stud.iterator();
	}
	
	
	
}

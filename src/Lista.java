import java.util.Iterator;

public class Lista implements Iterable<Student> {
	Element start = null;

	public void dodajNaKoniec(Student s) {
		if (start == null) {
			start = new Element(s, null);
		} else {
			Element last = start;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Element(s, null);
		}
	}

	public void dodajNaPoczatek(Student s) {
		if (start == null)
			start = new Element(s, null);
		else {
			Element pierw = new Element(s, start);
			start = pierw;
		}
	}

	public void usunOstatni() {
		if (start == null)
			System.out.println("Lista pusta");
		else if (start.next == null)
			start = null;

		else {
			Element last = start;
			while (last.next.next != null) {
				last = last.next;
			}
			last.next = null;
		}
	}

	public void usunPierwszy() {
		if (start == null)
			System.out.println("Lista pusta");
		else {
			start = start.next;
		}
	}

	public Student zwroc1(int n) { // numer w liscie
		if (start == null) {
			System.out.println("Lista pusta, wiêc nie ma takiego studenta");
			return null;
		} else {
			Element akt = start;
			for (int i = 0; i < n; i++) {
				if (akt != null) {
					akt = akt.next;
				} else {
					System.out.println("Nie ma takiego studenta");
					return null;
				}
			}
			return akt.student;

		}
	}

	public Student zwroc2(long n) { // numer indeksu
		if (start == null) {
			System.out.println("Lista pusta");
			return null;
		}
		Element akt = start;
		while (akt != null) {
			if (akt.student.nrAlbumu == n) {
				return akt.student;
			} else {
				akt = akt.next;
			}

		}
		return null;

	}

	public void edytuj(int n, Student s) {
		if (start == null)
			System.out.println("Lista pusta");
		else {
			Element akt = start;
			for (int i = 0; i < n; i++) {
				if (akt != null) {
					akt = akt.next;
				} else {
					System.out.println("Nie ma takiego studenta");
					return;
				}
			}
			akt.student = s;

		}

	}

	public Iterator<Student> iterator() {
		return new StudentIterator(this);
	}
	
	public int lens() {
		if(start == null) return 0;
		else {
			int i = 1;
			Element akt = start;
			while(akt.next != null) {
				akt = akt.next;
				i++;
			}
			return i;
		}
	}
	
	public Element zwrocE(int n) { // numer w liscie
		if (start == null) {
			System.out.println("Lista pusta, wiêc nie ma takiego studenta");
			return null;
		} else {
			Element akt = start;
			for (int i = 0; i < n; i++) {
				if (akt != null) {
					akt = akt.next;
				} else {
					System.out.println("Nie ma takiego studenta");
					return null;
				}
			}
			return akt;

		}
	}
	
	public void insert(int n, Student s) {
		int lens = lens();
		if(n<lens) {
			if(n==0) {
				dodajNaPoczatek(s);
			}
			else {
				Element e = zwrocE(n-1);
				Element nowy = new Element(s, e.next);
				e.next = nowy;
			}
		}
		else if(n==lens) {
			dodajNaKoniec(s);
		}
		else {
			for(int i = 0; i<n-lens; i++) {
				dodajNaKoniec(null);
			}
			dodajNaKoniec(s);
		}
	}
	

}
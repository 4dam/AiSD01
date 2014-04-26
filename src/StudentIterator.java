public class StudentIterator implements java.util.Iterator<Student> {
	Element current;

	public StudentIterator(Lista l) {
		current = l.start;
	}

	public boolean hasNext() {
		return current != null;
	}

	public Student next() {
		Element akt = current;
		if (current != null)
			current = current.next;
		if (akt != null)
			return akt.student;
		else
			return null;
	}

	public Student current() {
		if (current == null) {
			return null;
		} else {
			return current.student;
		}
	}

	public void remove() {
		System.out.println("Ta metoda nie dzia³a.");
	}

}
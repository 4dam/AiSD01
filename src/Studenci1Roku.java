import java.util.Iterator;

public class Studenci1Roku implements Iterator<Student> {

	public boolean hasNext() {
		if(!it.hasNext()) return false;
		if(zapisany != null) {
			return true;
		}
		else {
			while(it.hasNext()) {
				Student s = it.next();
				if(s.rokStudiow == 1) {
					zapisany = s;
					return true;
				}
			}
			return false;
		}
	}

	public Student next() {
		if(zapisany != null) {
			Student x = zapisany;
			zapisany = null;
			return x;
		}
		while (it.hasNext()) {
			Student s = it.next();
			if (s.rokStudiow == 1) {
				return s;
			}
		}
		return null;
	}

	public void remove() {

	}

	Iterator<Student> it;
	Student zapisany = null;

	public Studenci1Roku(Iterator<Student> it) {
		this.it = it;
	}
}
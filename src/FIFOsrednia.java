
public class FIFOsrednia extends Kolejka {
	
	public void dodaj(Student s) {
		int i = 0;
		for(Student o : stud) {
			if(s.srednia > o.srednia) break;
			i++;
		}
		stud.insert(i, s);
	}
	
	
	
}

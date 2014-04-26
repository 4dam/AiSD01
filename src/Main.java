import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
	 static Lista l = new Lista();
	public static void main(String[] args) {
		
	l.dodajNaPoczatek(new Student("AAAAA","aaaaaaa","22-2-2222",234567,2,4));
		l.dodajNaKoniec(new Student("BBBBBBB","bbbbbbb","11-1-1111",23421,1,2));
		l.dodajNaKoniec(new Student("CCCCCCC","cccccccc","33.3.3333",33421,1,2));
		l.dodajNaKoniec(new Student("DDDDDD","ddddddd","4-44-4444",2334521,5,2));
		l.usunOstatni();
		l.usunPierwszy();
	l.insert(3,new Student("asds","wesfd","99-99-9999",21343256,234,45));
		
//		for(Student s : l) { 
//			System.out.println(s);
//		}
		
//		Iterator<Student> it = new Studenci1Roku(l.iterator());
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
//		zapiszDoPliku();
//	czytajZPliku();
//
	l.insert(10,new Student("asds","wesfd","99-99-9999",21343256,234,45));

//	Iterator<Student> it = new Studenci1Roku(l.iterator());
//	while(it.hasNext()) {
//		System.out.println(it.next());
//	}
//	l.edytuj(1,new Student("EEEE","eeee","22-2-2222",222222,2,4));
		for(Student s : l) {
			System.out.println(s);
		}
//	zapiszDoPliku();

		//		
//		System.out.println(l.lens());
		
	}
	
	public static void czytajZPliku() {
		try{
		Scanner linia = new Scanner(new FileInputStream("baza.csv"));
		linia.useDelimiter("\r\n");
		while(linia.hasNext()) {
			Scanner srednik = new Scanner(linia.next());
			srednik.useDelimiter(";");
			String nazwisko = srednik.next();
			String imie = srednik.next();
			String dataUrodzenia = srednik.next();
			long nrAlbumu = srednik.nextLong();
			int rokStudiow = srednik.nextInt();
			double srednia = new Double(srednik.next());
			l.dodajNaKoniec(new Student(nazwisko,imie,dataUrodzenia,nrAlbumu,rokStudiow,srednia));
			srednik.close();
		}
		linia.close();
		
		
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
	public static void zapiszDoPliku() {
		try {
			FileWriter fw = new FileWriter("baza.csv");
			for(Student s : l) {
				fw.write(String.format("%s;%s;%s;%d;%d;%s%n",s.nazwisko,s.imie,s.dataUrodzenia,s.nrAlbumu,s.rokStudiow,s.srednia));
			}
			fw.close();
			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
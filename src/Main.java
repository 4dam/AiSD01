import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	 static Lista l = new Lista();
	static ArrayList<Kolejka> k = new ArrayList<Kolejka>();
	
	 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int wybor = 0;
	while(wybor != 99) {
		System.out.println("\n\t\tMENU\n\n"
				+ "1\tDodaj Studenta do listy\n"
				+ "2\tUsuñ pierwszego studenta z listy\n"
				+ "3\tEdutyj studenta z listy\n"
				+ "4\tWstaw studenta do listy na dane miejsce\n"
				+ "5\tWypisz studentów z listy\n"
				+ "6\tUsuñ ostatniego studenta z listy\n"
				+ "7\tZapisz listê do pliku\n"
				+ "8\tWczytaj listê z pliku\n"
				+ "\nKolejki:\n"
				+ "11\tUtworz kolejke\n"
				+ "12\tDodaj studenta do kolejki\n"
				+ "13\tUsun studenta z kolejki\n"
				+ "14\tWypisz zawartoœæ kolejki\n"
				+ "15\tLista kolejek \n"
				+ "16\tUsuñ kolejke \n\n"
				+ "99\tZamnkij program ");
		wybor = sc.nextInt();
		System.out.println("\n");
		switch (wybor) {
		case 1: 
			dodajstudenta(); break;
		case 2: usun(); break;
		case 3:
			edytuj(); break;
		case 4: wstaw(); break;
		case 5: wypiszl(); break;
		case 6: usuno(); break;
		case 7: zapiszDoPliku(); break;
		case 8: czytajZPliku(); break;
		case 11: utworz(); break;
		case 12:dodajk(); break;
		case 13: usunzkolejki(); break;
		case 14: wypiszk(); break;
		case 15: lista(); break;
		case 16: usunkk(); break;
		}
	}
	sc.close();
	System.out.println("Program zamkniêty");
	
	
	
	
	}	
	private static void usunzkolejki() {

		System.out.println("Podaj numer kolejki, z której usun¹æ studenta."); 
		Scanner sc = new Scanner(System.in);
		int jaka = sc.nextInt();
		//sc.close();
		if (jaka >= k.size()) {
			System.out.println("Nie ma tylu kolejek.");
			return;
		}
		k.get(jaka).usun();
		System.out.println("Student usuniêty.");
		
		
	}
	private static void usuno() {
		if(l.lens() == 0)  { System.out.println("Lista pusta");
		return; }
	l.usunOstatni();
	System.out.println("Ostatni student usuniêty.");
	
		
	}
	private static void usunkk() {
		System.out.println("Podaj numer kolejki do usuniêcia"); 
		Scanner sc = new Scanner(System.in);
		int jaka = sc.nextInt();
		//sc.close();
		if (jaka >= k.size()) {
			System.out.println("Nie ma tylu kolejek.");
			return;
		}
		
		k.remove(jaka);
		System.out.println("Usuniêto kolejkê o numerze: " + jaka );
		
	}
	private static void lista() {
		int i = 0;
		for (Kolejka x : k) {
			String rodzaj = x.getClass().getSimpleName();
			System.out.println(i++ + " --- " + rodzaj );
		}
		
		
		
	}
	private static void wypiszk() {
		System.out.println("Podaj numer kolejki.");
		Scanner sc = new Scanner(System.in);
		int jaka = sc.nextInt();
		//sc.close();
		if (jaka >= k.size()) {
			System.out.println("Nie ma tylu kolejek.");
			return;
		}
		int i = 0;
		for (Student x : k.get(jaka)) {
			
			System.out.println(i++ + " --- " + x);
		}
		
		
	}
	private static void dodajk() {
		System.out.println("Podaj numer studenta na liœcie i do jakiej olejki go dodaæ.");
		Scanner sc = new Scanner(System.in);
		int numer = sc.nextInt();
		int jaka = sc.nextInt();
		//sc.close();
		if (jaka >= k.size()) {
			System.out.println("Nie ma tylu kolejek.");
			return;
		}
		if (numer >= l.lens()) {
			System.out.println("Nie ma tylu studentów");
			return;
		}
		k.get(jaka).dodaj(l.zwroc1(numer));
		System.out.println("Student dodany do kolejki.");
		
	}
	private static void utworz() {
		System.out.println("Kolejka fifo(wg dodania studenta): 1\n"
				+ "kolejka fifo(wg œredniej): 2\n"
				+ "kolejka lifo(wg dodania studenta): 3\n"
				+ "kolejka lifo(wg œredniej): 4");
		Kolejka ko = null;
		Scanner sc = new Scanner(System.in);
		int wybor = sc.nextInt();
		switch(wybor) {
		case 1: ko= new Kolejka(); break;
		case 2: ko = new FIFOsrednia(); break;
		case 3: ko = new LIFO(); break;
		case 4: ko = new LIFOsrednia(); break;
		
		}
		k.add(ko);
		System.out.println("Kolejka dodana");
		
		//sc.close();
	}
	private static void wypiszl() {
		for(Student x : l) {
			System.out.println(x);
		}
		
	}
	private static void wstaw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj numer, na który studentt ma byæ wstawiony.");
		int numer = sc.nextInt();
		System.out.println("Podaj dane studenta(String nazwisko,	String imie, String dataUrodzenia, long nrAlbumu, int rokStudiow, double srednia)");
		String nazwisko = sc.next();
		String imie = sc.next();
		String dataUrodzenia = sc.next();
		long nrAlbumu = sc.nextLong();
		int rokStudiow = sc.nextInt();
		double srednia = sc.nextDouble();
		l.insert(numer, new Student(nazwisko, imie, dataUrodzenia, nrAlbumu, rokStudiow, srednia));
		System.out.println("Student dodany.");
		//sc.close();
		
		
		
	}
	private static void edytuj() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj numer studenta na liœcie");
		int numer = sc.nextInt();
		if(numer >= l.lens()) {
			System.out.println("Nie ma tylu studentów na liœcie"); 
			//sc.close();
			return;
		}
		System.out.println("Podaj dane studenta(String nazwisko,	String imie, String dataUrodzenia, long nrAlbumu, int rokStudiow, double srednia)");
		String nazwisko = sc.next();
		String imie = sc.next();
		String dataUrodzenia = sc.next();
		long nrAlbumu = sc.nextLong();
		int rokStudiow = sc.nextInt();
		double srednia = sc.nextDouble();
		l.edytuj(numer, new Student(nazwisko, imie, dataUrodzenia, nrAlbumu, rokStudiow, srednia));
		System.out.println("Edycja udana");
		//sc.close();
		
		
	}
	private static void usun() {
		if(l.lens() == 0)  { System.out.println("Lista pusta");
			return; }
		l.usunPierwszy();
		System.out.println("Pierwszy student usuniêty.");
		
		
	}
	private static void dodajstudenta() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj dane studenta(String nazwisko,	String imie, String dataUrodzenia, long nrAlbumu, int rokStudiow, double srednia)");
		String nazwisko = sc.next();
		String imie = sc.next();
		String dataUrodzenia = sc.next();
		long nrAlbumu = sc.nextLong();
		int rokStudiow = sc.nextInt();
		double srednia = sc.nextDouble();
		l.dodajNaKoniec(new Student(nazwisko, imie, dataUrodzenia, nrAlbumu, rokStudiow, srednia));
		System.out.println("Student dodany.");
//		sc.close();
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
		System.out.println("Zapisano.");
	}

}
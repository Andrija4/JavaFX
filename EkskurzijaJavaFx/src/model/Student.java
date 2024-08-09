package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student implements Comparable<Student>{

	private static final Set<Indeks> SVI_INDEKSI = new HashSet<Indeks>();
	private final String ime;
	private final String prezime;
	private final Indeks indeks;
	
	public Student(String ime, String prezime, Indeks indeks) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.indeks = indeks;
	}
	
	public Student createStudent(String ime, String prezime, int brojUpisa, int godinaUpisa, Smer smer) {
		
		for(Indeks i : SVI_INDEKSI) {
			
			if(i.getSmer() == smer && i.getBrojUpisa() == brojUpisa && i.getGodinaUpisa() == godinaUpisa) {
				System.err.println("Indeks vec postoji");
			}
		}
		Indeks indeks = new Indeks(brojUpisa, godinaUpisa, smer);
		return new Student(ime, prezime, indeks);
	}
	
	public boolean napijeSe() {
		if(Server.getInstance().getAutobusZaStudenta(this) == null)
			return false;
		if(Server.getInstance().getAutobusZaStudenta(this).getNastavnik().isStrog()) {
			Server.getInstance().getAutobusZaStudenta(this).izbaciStudenta();
			Server.getInstance().izbaciStudenta(this);
			return false;
		}
		return true;
	}
	
	public String getMail() {
		return (ime.charAt(0) + prezime + indeks.getBrojUpisa() + (indeks.getGodinaUpisa() % 100) + "@raf.rs" ).toLowerCase();
	}
	
	public String getIme() {
		return ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public Indeks getIndeks() {
		return indeks;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(indeks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(indeks, other.indeks);
	}

	@Override
	public int compareTo(Student o) {
		if(indeks.getGodinaUpisa() != o.indeks.getGodinaUpisa())
			return Integer.compare(indeks.getGodinaUpisa(), o.indeks.getGodinaUpisa());
		
		else if(indeks.getSmer() != o.indeks.getSmer())
			return indeks.getSmer().compareTo(o.indeks.getSmer());
		
		else if (indeks.getBrojUpisa() != o.indeks.getBrojUpisa())
			return Integer.compare(indeks.getBrojUpisa(), o.indeks.getBrojUpisa());
		
		return 0;
	}
	
	@Override
	public String toString() {
		return ime + " "+ prezime + " " + indeks;
	}
	
}

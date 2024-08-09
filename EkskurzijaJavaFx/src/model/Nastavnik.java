package model;

public class Nastavnik {
	
	private final String ime;
	private final String prezime;
	private final boolean strog;
	
	public Nastavnik(String ime, String prezime, boolean strog) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.strog = strog;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public boolean isStrog() {
		return strog;
	}
	
	

}

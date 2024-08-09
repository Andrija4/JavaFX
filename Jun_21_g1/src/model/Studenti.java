package model;

public class Studenti {
	
	private String smer;
	private int broj;
	private int godina;
	private String prezime;
	private String ime;
	
	public Studenti(String smer, int broj, int godina, String prezime, String ime) {
		super();
		this.smer = smer;
		this.broj = broj;
		this.godina = godina;
		this.prezime = prezime;
		this.ime = ime;
	}

	public String getSmer() {
		return smer;
	}

	public void setSmer(String smer) {
		this.smer = smer;
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
	public String getNesto() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return ime + " " + prezime + " " + broj + "/" + smer + "-" + godina;
	}

}

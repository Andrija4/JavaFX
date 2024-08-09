package model;

public class Artikal {
	
	private Izvodjac izvodjac;
	private String naziv;
	private int godina;
	private String zanr;
	private TipNosacaZvuka tip;
	private int komad;
	private int cena;
	private String kategorija;
	
	public Artikal(Izvodjac izvodjac, String naziv, int godina, String zanr, TipNosacaZvuka tip, int komad, int cena,
			String kategorija) {
		super();
		this.izvodjac = izvodjac;
		this.naziv = naziv;
		this.godina = godina;
		this.zanr = zanr;
		this.tip = tip;
		this.komad = komad;
		this.cena = cena;
		this.kategorija = kategorija;
	}

	public Izvodjac getIzvodjac() {
		return izvodjac;
	}

	public void setIzvodjac(Izvodjac izvodjac) {
		this.izvodjac = izvodjac;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public TipNosacaZvuka getTip() {
		return tip;
	}

	public void setTip(TipNosacaZvuka tip) {
		this.tip = tip;
	}

	public int getKomad() {
		return komad;
	}

	public void setKomad(int komad) {
		this.komad = komad;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getKategorija() {
		return kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	
	

	@Override
	public String toString() {
		return izvodjac + ",," + naziv + "\" " + cena + "din. ";
	}
	
	 
	
}
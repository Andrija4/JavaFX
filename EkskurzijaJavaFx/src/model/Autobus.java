package model;

public class Autobus {
	
	private final String naziv;
	private final Nastavnik nastavnik;
	private static final int MAX = 100;
	private int brojStudenata = 0;
	
	
	
	public Autobus(String naziv, Nastavnik nastavnik) {
		super();
		this.naziv = naziv;
		this.nastavnik = nastavnik;
	}
	
	public void izbaciStudenta() {
		--this.brojStudenata;
	}
	
	public boolean dodajStudenta() {
		if(this.brojStudenata >= this.MAX)
			return false;
		++this.brojStudenata;
		return true;
	}
	
	public String getNaziv() {
		return naziv;
	}
	
	public Nastavnik getNastavnik() {
		return nastavnik;
	}


	public int getBrojStudenata() {
		return brojStudenata;
	}
	
	@Override
	public String toString() {
		return naziv;
	}

	

}

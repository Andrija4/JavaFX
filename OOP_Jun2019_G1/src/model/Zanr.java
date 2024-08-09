package model;

public class Zanr {
	
	private String naziv;

	public Zanr(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	@Override
	public String toString() {
		
		return naziv;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || !(obj instanceof Zanr))
			return false;
		
		Zanr z = (Zanr) obj;
		return naziv.equals(z.naziv);
	}
	

}

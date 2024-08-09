package model;

public class Ucionice {
	String naziv;
	String tip;
	int maxStudenti;
	
	public Ucionice(String naziv, String tip, int maxStudenti) {
		super();
		this.naziv = naziv;
		this.tip = tip;
		this.maxStudenti = maxStudenti;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getMaxStudenti() {
		return maxStudenti;
	}

	public void setMaxStudenti(int maxStudenti) {
		this.maxStudenti = maxStudenti;
	}
	
	@Override
	public String toString() {
		return naziv +  tip + " - " + maxStudenti;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Ucionice))
			return false;
		Ucionice u = (Ucionice) obj;
		return naziv.equals(u.naziv);
	}
	

}

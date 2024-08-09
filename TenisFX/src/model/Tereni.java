package model;

import java.util.Objects;

public class Tereni implements Comparable<Tereni>{
	
	private String naziv;
	private String osvetljen;
	
	public Tereni(String naziv, String osvetljen) {
		super();
		this.naziv = naziv;
		this.osvetljen = osvetljen;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getOsvetljen() {
		return osvetljen;
	}

	@Override
	public int compareTo(Tereni o) {
		if(this.naziv != o.naziv)
			this.naziv.compareTo(o.naziv);
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(naziv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tereni other = (Tereni) obj;
		return Objects.equals(naziv, other.naziv);
	}
	
	@Override
	public String toString() {
		if(osvetljen == null)
			return naziv ;
		return naziv + " (" + osvetljen + ")";
	}

}

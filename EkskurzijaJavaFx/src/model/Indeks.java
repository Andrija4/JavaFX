package model;

import java.util.Objects;

public class Indeks {
	
	private int brojUpisa;
	private int godinaUpisa;
	private Smer smer;
	
	
	public Indeks(int brojUpisa, int godinaUpisa, Smer smer) {
		super();
		this.brojUpisa = brojUpisa;
		this.godinaUpisa = godinaUpisa;
		this.smer = smer;
	}


	public int getBrojUpisa() {
		return brojUpisa;
	}


	public void setBrojUpisa(int brojUpisa) {
		this.brojUpisa = brojUpisa;
	}


	public int getGodinaUpisa() {
		return godinaUpisa;
	}


	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}


	public Smer getSmer() {
		return smer;
	}


	public void setSmer(Smer smer) {
		this.smer = smer;
	}
	
	@Override
	public String toString() {
		return smer.toString() + brojUpisa +"/" + godinaUpisa;
	}


	@Override
	public int hashCode() {
		return Objects.hash(brojUpisa, godinaUpisa, smer);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indeks other = (Indeks) obj;
		return brojUpisa == other.brojUpisa && godinaUpisa == other.godinaUpisa && smer == other.smer;
	}
	
	

}

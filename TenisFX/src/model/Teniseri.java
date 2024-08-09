package model;

import java.util.Objects;

public class Teniseri implements Comparable<Teniseri>{
	
	private String poreklo;
	private String punoIme;
	private Character pol;
	private Integer rank;
	
	public Teniseri(String poreklo, String punoIme, Character pol, Integer rank) {
		super();
		this.poreklo = poreklo;
		this.punoIme = punoIme;
		this.pol = pol;
		this.rank = rank;
	}

	public String getPoreklo() {
		return poreklo;
	}

	public String getPunoIme() {
		return punoIme;
	}

	public Character getPol() {
		return pol;
	}
	
	public int getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return rank + ". " + "(" + poreklo + ") " + punoIme + " (" + pol + ")";
	}

	@Override
	public int compareTo(Teniseri o) {
		if(this.rank != o.rank)
			Integer.compare(this.rank, o.rank);
		if(this.pol != o.pol)
			this.pol.compareTo(o.pol);
		return 0;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(punoIme, pol, poreklo, rank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teniseri other = (Teniseri) obj;
		return Objects.equals(punoIme, other.punoIme) && Objects.equals(pol, other.pol)
				&& Objects.equals(poreklo, other.poreklo) 
				&& Objects.equals(rank, other.rank);
	}
	
	

}

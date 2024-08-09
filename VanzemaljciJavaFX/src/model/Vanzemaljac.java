package model;

import java.util.Objects;

public class Vanzemaljac {
	
	private String drzava;
	private String kontinent;
	private Integer id;
	
	public Vanzemaljac(String drzava, String kontinent, Integer id) {
		super();
		this.drzava = drzava;
		this.kontinent = kontinent;
		this.id = id;
	}

	public String getDrzava() {
		return drzava;
	}

	public String getKontinent() {
		return kontinent;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(drzava, id, kontinent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vanzemaljac other = (Vanzemaljac) obj;
		return Objects.equals(drzava, other.drzava) && id == other.id && Objects.equals(kontinent, other.kontinent);
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	 

}

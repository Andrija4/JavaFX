package model;

import java.util.Map;
import java.util.Set;

public class Artikli {
	
	//Ella Fitzgerald,Ella and Louis,2020,Vinyl,Jazz,2399,nova
	private String izvodjac;
	private String naziv;
	private int godina;
	private String tip;
	private Zanr zanr;
	private int cena;
	private String stanje;
	private int kolicina;
	private Map<String, Integer> mNovo;
	private Map<String, Integer> mPolovno;
	
	
	public Artikli(String izvodjac, String naziv, int godina, String tip, Zanr zanr, int cena, String stanje, int kolicina, Map<String, Integer> mNovo, Map<String, Integer> mPolovno) {
		super();
		this.izvodjac = izvodjac;
		this.naziv = naziv;
		this.godina = godina;
		this.tip = tip;
		this.zanr = zanr;
		this.cena = cena;
		this.stanje = stanje;
		this.kolicina = kolicina;
		this.mNovo = mNovo;
		this.mPolovno = mPolovno;
	}
	public String getIzvodjac() {
		return izvodjac;
	}
	public void setIzvodjac(String izvodjac) {
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
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public Zanr getZanr() {
		return zanr;
	}
	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public String getStanje() {
		return stanje;
	}
	public void setStanje(String stanje) {
		this.stanje = stanje;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public Map<String, Integer> getmNovo() {
		return mNovo;
	}
	public void setmNovo(Map<String, Integer> mNovo) {
		this.mNovo = mNovo;
	}
	public Map<String, Integer> getmPolovno() {
		return mPolovno;
	}
	public void setmPolovno(Map<String, Integer> mPolovno) {
		this.mPolovno = mPolovno;
	}
	public String getNesto() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		
		return izvodjac + " \"" + naziv + "\" " + godina + " (" + stanje + ") " + cena +" din. " + kolicina + " " +  tip;
	}

}

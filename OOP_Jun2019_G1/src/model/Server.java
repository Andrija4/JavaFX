package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Server {
	
	private static Server instance = null;

	private List<Artikli> artikli;
	private Map<String, Integer> mNovo;
	private Map<String, Integer> mPolovno;
	private Set<Zanr> zanr;
	
	
	
	private Server() {
		this.artikli = new ArrayList<Artikli>();
		this.mNovo = new TreeMap<String, Integer>();
		this.mPolovno = new TreeMap<String, Integer>();
		this.zanr = new TreeSet<Zanr>((a,b)->a.getNaziv().compareTo(b.getNaziv()));
		
		
		
		ucitajIzFile();
	}



	private void ucitajIzFile() {
		
		this.artikli.clear();
		this.zanr.clear();
		this.mPolovno.clear();
		this.mNovo.clear();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("katalog.txt");
			br = new BufferedReader(fr);
			
			String linija;
			while((linija = br.readLine()) != null) {
				//Ella Fitzgerald,Ella and Louis,2020,Vinyl,Jazz,2399,nova
				
				
				String[] delovi = linija.split(",");
				
				if(delovi.length != 7) {
					System.err.println("Greska u liniji");
					continue;
				}
				
				String izvodjac = delovi[0];
				String naziv = delovi[1];
				int godina = Integer.parseInt(delovi[2]);
				
				int kolicina = 1;
				String tip = delovi[3];
				
				if(delovi[3].contains("-")) {
					String[] poddelovi = delovi[3].split("-");
					tip = poddelovi[0];
					kolicina = Integer.parseInt(poddelovi[1]);
				}
				
				Zanr zanr = new Zanr(delovi[4]);
				
				this.zanr.add(zanr);
								
				int cena = Integer.parseInt(delovi[5]);
				String stanje = delovi[6];
				
				if(stanje.equals("nova")) 
					mNovo.put(stanje, kolicina);
				
				else if(stanje.equals("polovna"))
					mPolovno.put(stanje, kolicina);
				
				
				
				Artikli a = new Artikli(izvodjac, naziv, godina, tip, zanr, cena, stanje, kolicina, mNovo, mPolovno);
				
				this.artikli.add(a);
				
				System.out.println(mNovo);
				}
			
			fr.close();
			br.close();
			
			
			
		} catch (Exception e) {
			
			if(e instanceof FileNotFoundException)
				System.err.println("File nije pronadjen u folderu!");
			else if(e instanceof NumberFormatException)
				System.err.println("Greska prilikom parsiranja");
			
			e.getStackTrace();
		}
		
		
		
	}


	public List<Artikli> getArtikli() {
		return artikli;
	}

	public Map<String, Integer> getmNovo() {
		return mNovo;
	}

	public Map<String, Integer> getmPolovno() {
		return mPolovno;
	}

	public Set<Zanr> getZanr() {
		return zanr;
	}


	public static Server getInstance() {
		if(instance == null)
			instance = new Server();
		return instance;
	}
}

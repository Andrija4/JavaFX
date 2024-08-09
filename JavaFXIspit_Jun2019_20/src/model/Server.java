package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Server {
	
	private static Server instance = null;
	
	private List<Artikal> artikli;
	private Set<Izvodjac> izvodjaci;
	
	private final String podaciFile = "katalog.txt";
	
	private Server() {
		this.artikli = new ArrayList<Artikal>();
		this.izvodjaci = new TreeSet<Izvodjac>();
		
		ucitavanjeFajla();
	}
	
	private void ucitavanjeFajla() {
		
		this.artikli.clear();
		this.izvodjaci.clear();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader(new File(podaciFile));
			br = new BufferedReader(fr);
			
			String linija;
			String zanr = null;
			
			while((linija = br.readLine()) != null) {
				
				String[] delovi = linija.split(",");
				if(delovi.length == 1){
					zanr = delovi[0];
					continue;
				}
				
				if(delovi.length != 6) {
					System.err.println("Greska neka");
					continue;
				}
				
				Izvodjac izvodjac = new Izvodjac(delovi[0]);
				String naslov = delovi[1];
				int godinaIzdanja = Integer.parseInt(delovi[2]);
				
				String[] poddelovi = delovi[3].split("-");
				TipNosacaZvuka tip = TipNosacaZvuka.valueOf(poddelovi[0]);
				int komadi = Integer.parseInt(poddelovi[1]);
				int cena = Integer.parseInt(delovi[4]);
				String kategorija = delovi[5];
				
				Artikal a = new Artikal(izvodjac, naslov, godinaIzdanja, zanr, tip, komadi, cena, kategorija);
				//System.out.println(linija);
				this.artikli.add(a);
				
			}
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			
			if(e instanceof FileNotFoundException)
				System.err.println("Fajl " + podaciFile + " nije pronadjen");
			else if(e instanceof NumberFormatException)
				System.err.println("Gresko prilikom parsiranja godine! ");
			e.printStackTrace();
		}	
		
		System.out.println(artikli);
	}

	public static Server getInstance() {
		if(instance == null)
			instance = new Server();
		return instance;
	}
	
	public List<Artikal> getArtikli() {
		return artikli;
	}
	
	public Set<Izvodjac> getIzvodjaci() {
		return izvodjaci;
	}

}

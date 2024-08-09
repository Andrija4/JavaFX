package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static Server instance = null;
	
	private List<Studenti> studenti;
	private List<Ucionice> ucionice;
	private List<Termini> termini;
	
	
	public Server() {
		super();
		this.studenti = new ArrayList<Studenti>();
		this.ucionice = new ArrayList<Ucionice>();
		this.termini = new ArrayList<Termini>();
		
		ucitajFile();
		ucitajUcionice();
	}

	




	private void ucitajFile() {
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			this.studenti.clear();
			
			fr = new FileReader("studenti1.txt");
			br = new BufferedReader(fr);
			
			String linija = "";
			while((linija = br.readLine()) != null) {
				//System.out.println(linija);
				
				String[] delovi = linija.split(",");
				
				if(delovi.length != 5) {
					System.err.println("Pogresan upis podataka u fajl !");
					continue;
				}
				
				String smer = delovi[0];
				int broj = Integer.parseInt(delovi[1]);
				int godina = Integer.parseInt(delovi[2]);
				String prezime = delovi[3];
				String ime = delovi[4];
				
				Studenti studenti = new Studenti(smer, broj, godina, prezime, ime);
				this.studenti.add(studenti);
				
				
			}
			fr.close();
			br.close();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}



	private void ucitajUcionice() {
		ucionice.clear();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			
			fr = new FileReader("ucionice1.txt");
			br = new BufferedReader(fr);
			
			String linija = "";
			while((linija = br.readLine()) != null) {
				
				//Ako nema crtku
				String naziv = linija;
				String tip = "";
				int maxStudenti = 15;
				
				//Ako ima crtku
				if(linija.contains("-")) {
					String[] delovi = linija.split("-");
					naziv = delovi[0];
					tip = "(" + delovi[1] + ")";
					maxStudenti = 15;
					if(tip.equals("(A)")) {
						maxStudenti = 30;
						tip = "";
					}
					
					Ucionice ucionice = new Ucionice(naziv, tip, maxStudenti);
				}
				
				//Ubacivanje
				Ucionice ucionice = new Ucionice(naziv, tip, maxStudenti);
				this.ucionice.add(ucionice);
				
				System.out.println(ucionice);
			}
			
			fr.close();
			br.close();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
	}



	public List<Studenti> getStudenti() {
		return studenti;
	}







	public List<Ucionice> getUcionice() {
		return ucionice;
	}





	public List<Termini> getTermini() {
		return termini;
	}







	public static Server getInstance() {
		
		if(instance == null)
			instance = new Server();
		return instance;
		
	}

}

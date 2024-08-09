package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server {
	private static Server instance = null;
	
	Map<String, String> regija;
	List<Vanzemaljac> vanzemaljac;
	List<Integer> id;
	List<String> drzave;
	List<String> kontinenti;
	
	private Server () {
		this.regija = new HashMap<String, String>();
		this.id = new ArrayList<Integer>();
		this.drzave = new ArrayList<String>();
		this.kontinenti = new ArrayList<String>();
		this.vanzemaljac = new ArrayList<Vanzemaljac>();
		
		ucitajIzFajla();
	}
	
	
	
	
	private void ucitajIzFajla() {
		regija.clear();
		id.clear();
		drzave.clear();
		kontinenti.clear();
		vanzemaljac.clear();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader("vanzemaljci.txt");
			br = new BufferedReader(fr);
			String kontinent = null;
			String drzava = null;
			Integer id = null;
			
			String linija;
			while((linija = br.readLine())!=null) {
				
				//System.out.println(linija);
				
				
				if(linija.contains(":")) { 
					String[] delovi = linija.split(": ");
					kontinenti.add(delovi[1]);
					kontinent = delovi[1];
					continue;
				}
				
				if(linija.contains("IZGUBLJENI") || linija.contains("PRONADJENI"))
					continue;
				
				if(linija.contains(";")) {
					String[] delovi = linija.split(";");
					if(kontinenti.contains(delovi[1])) {
						
						id = Integer.valueOf(delovi[0]);
						kontinent = delovi[1];
						Vanzemaljac v = new Vanzemaljac(null, kontinent, id);
						vanzemaljac.add(v);
						continue;
					}
					else {
						id = Integer.valueOf(delovi[0]);
						drzava = delovi[1];
						
						Vanzemaljac v = new Vanzemaljac(drzava, regija.get(drzava), id);
						vanzemaljac.add(v);
						continue;
					}
				}
				drzave.add(linija);
				drzava = linija;
				regija.put(drzava, kontinent);
				
			}
			fr.close();
			br.close();
			
		} catch (Exception e) {
			
			
			
			e.getStackTrace();
		}
	}


	


	public List<Vanzemaljac> getVanzemaljac() {
		return vanzemaljac;
	}




	public List<String> getDrzave() {
		return drzave;
	}




	public List<String> getKontinenti() {
		return kontinenti;
	}

	


	public Map<String, String> getRegija() {
		return regija;
	}




	public static Server getInstance() {
		if(instance == null)
			instance = new Server();
		return instance;
	}

}

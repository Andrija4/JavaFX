package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static Server instance = null;
	
	List<Teniseri> teniseriM;
	List<Teniseri> teniseriZ;
	List<Teniseri> teniseri;
	List<Tereni> tereni;
	
	
	public Server() {
		this.teniseriM = new ArrayList<Teniseri>();
		this.teniseriZ = new ArrayList<Teniseri>();
		this.tereni = new ArrayList<Tereni>();
		this.teniseri = new ArrayList<Teniseri>();
		
		
		ucitajIzFileTereni();
		ucitajIzFileZene();
		ucitajIzFileMuskarci();
		
	}
	

	FileReader fr = null;
	BufferedReader br = null;

	private void ucitajIzFileTereni() {
		tereni.clear();
		
		try {
			String naziv;
			String osvetljen;
			
			fr = new FileReader("tereni.txt");
			br = new BufferedReader(fr);
			
			String linija = null;
			while((linija = br.readLine()) != null) {
				  System.out.println(linija);
				  
				  if(linija.contains("-")) {
					  String[] delovi = linija.split("-");
					  naziv = delovi[0];
					  osvetljen = delovi[1];
					  Tereni t = new Tereni(naziv, osvetljen);
					  tereni.add(t);
					  continue;
				  }
				  naziv = linija;
				  Tereni t = new Tereni(naziv, null);
				  tereni.add(t);
				  
				
			}
			fr.close();
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void ucitajIzFileMuskarci() {
		teniseriM.clear();
		
		try {
			Integer rank;
			String poreklo;
			String punoIme;
			Character pol = 'M';
			
			fr = new FileReader("muskarci.txt");
			br = new BufferedReader(fr);
			
			String linija = null;
			while((linija = br.readLine()) != null) {
				
				
				String[] delovi = linija.split(",");
				rank = Integer.parseInt(delovi[0]);
				poreklo = delovi[1];
				punoIme = delovi[2];
				
				System.out.println(rank);
				
				Teniseri t = new Teniseri(poreklo, punoIme, pol, rank);
				teniseriM.add(t);
			}
			fr.close();
			br.close();
			teniseri.addAll(teniseriM);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void ucitajIzFileZene() {
		teniseriZ.clear();
		
		try {
			Integer rank;
			String poreklo;
			String punoIme;
			Character pol = 'Z';
			
			fr = new FileReader("zene.txt");
			br = new BufferedReader(fr);
			
			String linija = null;
			while((linija = br.readLine())!=null) {
				
				String[] delovi = linija.split(",");
				rank = Integer.parseInt(delovi[0]);
				poreklo = delovi[1];
				punoIme = delovi[2];
				
				System.out.println(rank);
				
				Teniseri t = new Teniseri(poreklo, punoIme, pol, rank);
				teniseriZ.add(t);
				
			}
			fr.close();
			br.close();
			teniseri.addAll(teniseriZ);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

	public List<Tereni> getTereni() {
		return tereni;
	}

	public List<Teniseri> getTeniseriM() {
		return teniseriM;
	}

	public List<Teniseri> getTeniseriZ() {
		return teniseriZ;
	}
	public List<Teniseri> getTeniseri() {
		return teniseri;
	}

	public static Server getInstance() {
		if(instance == null)
			instance = new Server();
		return instance;
	}


	

}

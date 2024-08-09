package controller;


import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Server;
import model.Vanzemaljac;
import view.MainView;

public class SacuvajController implements EventHandler<ActionEvent>{
	
	private MainView view;
	
	public SacuvajController(MainView view) {
		this.view = view;
	}
	
	

	@Override
	public void handle(ActionEvent event) {
		
		try {
			
			FileWriter fw = new FileWriter(new File("regije"));
			PrintWriter pw = new PrintWriter(fw);
			
			for(String drzava : Server.getInstance().getDrzave()) {
				Integer broj = 0;
				for(Vanzemaljac v : Server.getInstance().getVanzemaljac()) {
					if(v.getDrzava() == null)
						continue;
					else if(v.getDrzava().equals(drzava))
						broj++;
				}
				pw.println("Broj vanzemaljaca: " + broj.toString() + ", " + drzava);
			}
			
			fw.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

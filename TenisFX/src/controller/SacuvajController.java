package controller;

import java.io.FileWriter;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Termini;
import view.MainView;

public class SacuvajController implements EventHandler<ActionEvent>{
	
	private MainView view;
	
	public SacuvajController(MainView view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		FileWriter fw;
		PrintWriter pw;
		
		try {
			fw = new FileWriter("mecevi.txt");
			pw = new PrintWriter(fw);
			
			for(Termini t : view.getTvTermini().getItems()) {
				pw.println(t.toString() + "\n");
			}
			
			
			fw.close();
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

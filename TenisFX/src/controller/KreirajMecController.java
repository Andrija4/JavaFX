package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Termini;
import view.MainView;

public class KreirajMecController implements EventHandler<ActionEvent>{
	
	private MainView view;
	Integer brojac = -1;
	String[] vreme = {"09:00", "12:00", "15:00", "18:00"};
	
	public KreirajMecController(MainView view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		
		
		
		if(view.getLvTereni().getSelectionModel().getSelectedItem() == null)
			System.err.println("Niste selektovali teren");
		else {
			Termini t = new Termini(view.getLvTereni().getSelectionModel().getSelectedItem().toString(), null, null, null);
			view.getTvTermini().getItems().add(t);
			
			for(Termini g : view.getTvTermini().getItems()) {
				if(t.equals(g))
					brojac++;
			}
			int indexPrethodni = view.getTvTermini().getItems().indexOf(t)-1;
			if(indexPrethodni < 0) {
				indexPrethodni = 0;
			}
			Termini prethodni = view.getTvTermini().getItems().get(indexPrethodni);
			if(!(t.getTeren().equals(prethodni.getTeren()))) {
				brojac--;
			}
				
			if(t.getTeren().contains("(O)")) {
				if(brojac>3)
					brojac = 0;
			}
			else {
				if(brojac>2)
					brojac = 0;
			}
			
			view.getTvTermini().getItems().remove(t);
			t = new Termini(view.getLvTereni().getSelectionModel().getSelectedItem().toString(), vreme[brojac], null, null);
			view.getTvTermini().getItems().add(t);
		}
		
	}

}

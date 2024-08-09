package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Server;
import model.Student;
import view.MainView;

public class FiltrirajController implements EventHandler<ActionEvent>{

	private MainView view;
	
	public FiltrirajController(MainView view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		view.getLvStudenti().getItems().clear();
		view.getVbLabele().getChildren().clear();

		List<Student> listDolaze = new ArrayList<Student>();
		
		for(Student s:Server.getInstance().getStudenti()) {
			
			//Ubacivanje studenata preko radio buttona
			if(view.getRbRN().isSelected()) {
				if(s.getIndeks().getSmer().equals("RN"));
					listDolaze.add(s);
			}
			else if(view.getRbRI().isSelected()) {
				if(s.getIndeks().getSmer().equals("RI"));
					listDolaze.add(s);
			}
			else if(view.getRbRD().isSelected()) {
				if(s.getIndeks().getSmer().equals("RD"));
					listDolaze.add(s);
			}
			else if(view.getRbS().isSelected()) {
				if(s.getIndeks().getSmer().equals("S"));
					listDolaze.add(s);
			}
			else
				System.err.println("Prazni radio buttoni");
			
			//Izbacivanje studenata koji nisu na ekskurziji 
			if(view.getCbStudenti().isSelected()) {
				if(Server.getInstance().getAutobusZaStudenta(s) == null)
					listDolaze.remove(s);
			}
			
			if(Server.getInstance().getAutobusZaStudenta(s).equals(view.getCbAutobusi())) {
				view.getVbLabele().getChildren().add(new Label(s.toString()));
			}
			
		}
		
		view.getLvStudenti().getItems().addAll(listDolaze);
	}
	
	

}

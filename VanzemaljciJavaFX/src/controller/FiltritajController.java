package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Server;
import model.Vanzemaljac;
import view.MainView;

public class FiltritajController implements EventHandler<ActionEvent>{
	private MainView view;
	List<Vanzemaljac> filtritaniVanzemaljci = new ArrayList<Vanzemaljac>();
	
	public FiltritajController(MainView view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		
		view.getTvVanzemaljac().getItems().clear();
		filtritaniVanzemaljci.clear();
		
		for(Vanzemaljac v:Server.getInstance().getVanzemaljac()) {
			
			if(view.getCbKontinent().getSelectionModel().getSelectedItem().equals("Svi"))
				filtritaniVanzemaljci.add(v);
			
			if(view.getCbKontinent().getSelectionModel().getSelectedItem().equals(v.getKontinent())) {
				filtritaniVanzemaljci.add(v);
			}
			
			if(view.getPronadjen().isSelected()) {
				if(v.getDrzava() == null)
					filtritaniVanzemaljci.remove(v);
			}
			
			if(view.getIzgubljen().isSelected()) {
				if(v.getDrzava() != null)
					filtritaniVanzemaljci.remove(v);
			}
			
			if(view.getIzgubljen().isSelected() && view.getPronadjen().isSelected()) {
				if(view.getCbKontinent().getSelectionModel().getSelectedItem().equals("Svi"))
					filtritaniVanzemaljci.add(v);
				
				if(view.getCbKontinent().getSelectionModel().getSelectedItem().equals(v.getKontinent())) {
					filtritaniVanzemaljci.add(v);
				}
			}
				
			
			
			
			
		}
		
		view.getTvVanzemaljac().getItems().addAll(filtritaniVanzemaljci);
		
	}

}

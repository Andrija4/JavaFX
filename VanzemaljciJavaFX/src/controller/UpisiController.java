package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Server;
import model.Vanzemaljac;
import view.MainView;

public class UpisiController implements EventHandler<ActionEvent>{

	private MainView view;
	
	public UpisiController(MainView view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		ObservableList<Vanzemaljac> selektovani = view.getTvVanzemaljac().getSelectionModel().getSelectedItems();
		if(view.getTvVanzemaljac().getSelectionModel().getSelectedItem() != null) {
			for(Vanzemaljac v: selektovani) {
				if(v.getDrzava() == null) {
					String drzava = view.getCbDrzava().getSelectionModel().getSelectedItem();
					if(Server.getInstance().getRegija().get(drzava).equals(v.getKontinent()) ) {
						v.setDrzava(view.getCbDrzava().getSelectionModel().getSelectedItem());
						view.getTvVanzemaljac().refresh();
						view.getPoruka().setText("Uspesno upisivanje");
					}
					else {
						System.err.println("Pogresan kontinent");
						view.getPoruka().setText("Pogresan kontinent");
					}
				}
				else {
					System.err.println("Izabrali ste pronadjenog vanzemaljca");
					view.getPoruka().setText("Vanzemaljac je pronadjen");
				}
			}
		}
		else {
			System.err.println("Niste selektovali ni jedan element u tabeli");
			view.getPoruka().setText("Izaberi element");
		}
	}

}

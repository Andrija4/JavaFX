package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Server;
import model.Teniseri;
import view.MainView;

public class FiltrirajController implements EventHandler<ActionEvent>{
	List<Teniseri> filtritaniTeniseri = new ArrayList<Teniseri>();

	private MainView view;
	
	public FiltrirajController(MainView view) {
		this.view = view;
	}
	
	@Override
	public void handle(ActionEvent event) {
		view.getLvTeniseri().getItems().clear();
		filtritaniTeniseri.clear();
		
		for(Teniseri t : Server.getInstance().getTeniseri()) {
			if(t.toString().contains(view.getTfIgrac().getText())) {
				if(view.getCbMusko().isSelected()) {
					if(t.getPol().equals('M'))
						filtritaniTeniseri.add(t);
				}
				if(view.getCbZensko().isSelected()) {
					if(t.getPol().equals('Z'))
						filtritaniTeniseri.add(t);
				}
				if(!(view.getCbMusko().isSelected()) && !(view.getCbZensko().isSelected()))
					filtritaniTeniseri.add(t);
					
			}
		}
		
		view.getLvTeniseri().getItems().addAll(filtritaniTeniseri);
	}
}
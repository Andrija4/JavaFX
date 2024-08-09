package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Teniseri;
import model.Termini;
import view.MainView;

public class DodajIgraceController implements EventHandler<ActionEvent>{
	
	private MainView view;
	
	public DodajIgraceController(MainView view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		List<Teniseri> teniseri = new ArrayList<Teniseri>();
		List<String> imena = new ArrayList<String>();
		
		if(view.getLvTeniseri().getSelectionModel().getSelectedItems().size() == 0)
			System.err.println("Niste izabrali ni jednog igraca iz liste !");
		else if(view.getLvTeniseri().getSelectionModel().getSelectedItems().size() > 2)
			System.err.println("Previse igraca ste izabrali iz liste !");
		else {
			teniseri.addAll(view.getLvTeniseri().getSelectionModel().getSelectedItems());
			for(Teniseri t : teniseri) {
				imena.add(t.getPunoIme());
			}
			if(view.getTvTermini().getItems().isEmpty())
				System.err.println("Niste ubacili termine");
			else {
				
				
				for(Termini ter : view.getTvTermini().getItems()) {
					
					if(ter.getPrviTim() == null) {
						if(imena.size() == 1) {
							ter.setPrviTim(imena.get(0));
							view.getTvTermini().refresh();
							break;
						}
						else {
							ter.setPrviTim(imena.get(0) + "/" + imena.get(1));
							view.getTvTermini().refresh();
							break;
						}
					}
					else if(ter.getDrugiTim() == null) {
						if(imena.size() == 1 && !(ter.getPrviTim().contains("/"))) {
							ter.setDrugiTim(imena.get(0));
							view.getTvTermini().refresh();
							break;
						}
						else if(ter.getPrviTim().contains("/")){
							ter.setDrugiTim(imena.get(0) + "/" + imena.get(1));
							view.getTvTermini().refresh();
							break;
						}
						else
							System.err.println("Timovi nisu jednaki");
						
					}
					else
						continue;
				}
				
			}
		}
		
	}

}

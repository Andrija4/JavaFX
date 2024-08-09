package view;

import controller.FiltrirajController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Autobus;
import model.Server;
import model.Student;

public class MainView extends Stage{
	
	private static MainView instance = null;
	
	private Scene scene;
	
	VBox root = new VBox(10);
	
	
	
	//element1
	HBox e1 = new HBox(5);
	CheckBox cbStudenti = new CheckBox();
	
	//element2
	HBox e2 = new HBox(20);
	
	VBox vRadio = new VBox(8);
	RadioButton rbRN = new RadioButton("RN");
	RadioButton rbRI = new RadioButton("RI");
	RadioButton rbRD = new RadioButton("RD");
	RadioButton rbS = new RadioButton("S");
	
	ListView<Student> lvStudenti = new ListView<Student>();
	
	VBox cAutobusi = new VBox(10);
	ComboBox<Autobus> cbAutobusi = new ComboBox<Autobus>();
	VBox vbLabele = new VBox(8);
	Label lStudent1 = new Label("Ime1 Prezime1 RN1/2021");
	Label lStudent2 = new Label("Ime2 Prezime2 RN2/2021");
	
	//element3
	HBox e3 = new HBox(10);
	Button btnFiltriraj = new Button("Filtriraj");
	Button btnOsvezi = new Button("Osvezi");
	
	
	private void element1(){
		e1.setAlignment(Pos.CENTER);
		e1.getChildren().add(cbStudenti);
		cbStudenti.setSelected(true);
		e1.getChildren().add(new Label("Prikazi samo one studente koji dolaze"));
		
	}
	
	private void element2() {
		e2.setAlignment(Pos.CENTER);
		
		e2.getChildren().add(vRadio);
		vRadio.setAlignment(Pos.CENTER_LEFT);
		
		ToggleGroup tg = new ToggleGroup();
		rbRN.setToggleGroup(tg);
		rbRI.setToggleGroup(tg);
		rbRD.setToggleGroup(tg);
		rbS.setToggleGroup(tg);
		
		vRadio.getChildren().add(rbRN);
		vRadio.getChildren().add(rbRI);
		vRadio.getChildren().add(rbRD);
		vRadio.getChildren().add(rbS);
		rbRN.fire();
		
		e2.getChildren().add(lvStudenti);
		lvStudenti.getItems().addAll(Server.getInstance().getStudenti());
		
		e2.getChildren().add(cAutobusi);
		cAutobusi.setAlignment(Pos.TOP_CENTER);
		cAutobusi.setPadding(new Insets(10, 10, 10, 5));
		cAutobusi.getChildren().add(cbAutobusi);
		cAutobusi.getChildren().add(vbLabele);
		vbLabele.setAlignment(Pos.TOP_CENTER);
		vbLabele.getChildren().add(lStudent1);
		vbLabele.getChildren().add(lStudent2);
		
		cbAutobusi.setMinWidth(100);
		cbAutobusi.getItems().addAll(Server.getInstance().getAutobusi());
		
	}
	
	private void element3() {
		e3.setAlignment(Pos.CENTER);
		e3.getChildren().add(btnFiltriraj);
		e3.getChildren().add(btnOsvezi);
	}
	
	private void createScene() {
		element1();
		element2();
		element3();
		
		root.getChildren().add(e1);
		root.getChildren().add(e2);
		root.getChildren().add(e3);
		
	}
	
	
	private MainView() {
		setTitle("Ekskurzija");
		root.setAlignment(Pos.CENTER);
		scene = new Scene(root, 500, 500);
		
		createScene();
		actions();
		
		setScene(scene);
		show();
	}




	private void actions() {
		

		btnFiltriraj.setOnAction(new FiltrirajController(this));
		
		btnOsvezi.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				lvStudenti.getItems().clear();
				lvStudenti.getItems().addAll(Server.getInstance().getStudenti());
			}
		});
		
	}

	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		return instance;
	}

	public CheckBox getCbStudenti() {
		return cbStudenti;
	}

	public RadioButton getRbRN() {
		return rbRN;
	}

	public RadioButton getRbRI() {
		return rbRI;
	}

	public RadioButton getRbRD() {
		return rbRD;
	}

	public RadioButton getRbS() {
		return rbS;
	}

	public ListView<Student> getLvStudenti() {
		return lvStudenti;
	}

	public ComboBox<Autobus> getCbAutobusi() {
		return cbAutobusi;
	}

	public Label getlStudent1() {
		return lStudent1;
	}

	public Label getlStudent2() {
		return lStudent2;
	}
	
	public VBox getVbLabele() {
		return vbLabele;
	}
	
	

}

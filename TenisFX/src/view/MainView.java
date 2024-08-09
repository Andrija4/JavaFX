package view;

import controller.DodajIgraceController;
import controller.FiltrirajController;
import controller.KreirajMecController;
import controller.SacuvajController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Teniseri;
import model.Tereni;
import model.Termini;

public class MainView extends Stage{
	
	private static MainView instance = null;
	
	private Scene scene;
	VBox root = new VBox(10);
	
	
	public MainView() {
		setTitle("Teniski turnir");
		root.setAlignment(Pos.CENTER);
		scene = new Scene(root, 580, 570);
		createScene();
		setScene(scene);
		show();
	}
	
	//element1
	HBox e1 = new HBox(15);
	VBox e1_1 = new VBox(10);
	VBox e1_2 = new VBox(50);
	HBox e1_1_1 = new HBox(5);
	//e1_1
	
	//e1_1_1
	TextField tfIgrac = new TextField();
	Button btnFiltritaj = new Button("Filtritaj");
	CheckBox cbMusko = new CheckBox("M");
	CheckBox cbZensko = new CheckBox("Z");
	//e1_1_2
	ListView<Teniseri> lvTeniseri = new ListView<Teniseri>();
	
	//e1_2
	Button btnKreirajMec = new Button("Kreiraj mec");
	Button btnDodajIgrace = new Button("Dodaj igrace");
	
	//e1_3
	ListView<Tereni> lvTereni = new ListView<Tereni>();
	
	//e2
	TableView<Termini> tvTermini = new TableView<Termini>();
	
	//e3 
	Button btnSacuvaj = new Button("Sacuvaj meceve");
	

	private void createScene() {
		
		element1();
		root.getChildren().add(e1);
		root.getChildren().add(tvTermini);
		
		TableColumn<Termini, String> tcTeren = new TableColumn<Termini, String>("Teren");
		tcTeren.setCellValueFactory(new PropertyValueFactory<>("teren"));
		tvTermini.getColumns().add(tcTeren);
		
		TableColumn<Termini, String> tcVreme = new TableColumn<Termini, String>("Vreme");
		tcVreme.setCellValueFactory(new PropertyValueFactory<>("vreme"));
		tvTermini.getColumns().add(tcVreme);
		
		TableColumn<Termini, String> tcPrviTim = new TableColumn<Termini, String>("Prvi tim");
		tcPrviTim.setCellValueFactory(new PropertyValueFactory<>("prviTim"));
		tvTermini.getColumns().add(tcPrviTim);
		
		TableColumn<Termini, String> tcDrugiTim = new TableColumn<Termini, String>("Drugi tim");
		tcDrugiTim.setCellValueFactory(new PropertyValueFactory<>("drugiTim"));
		tvTermini.getColumns().add(tcDrugiTim);
		
		
		tvTermini.setMaxHeight(230);
		tvTermini.setMaxWidth(550);
		root.getChildren().add(btnSacuvaj);
		btnSacuvaj.setOnAction(new SacuvajController(this));
		
	}
	
	private void element1() {
		e1.setAlignment(Pos.CENTER);
		
		e1.getChildren().add(e1_1);
		e1_1.setAlignment(Pos.CENTER);
		e1_1.getChildren().add(e1_1_1);
		e1_1_1.setAlignment(Pos.CENTER);
		e1_1_1.getChildren().add(tfIgrac);
		e1_1_1.getChildren().add(btnFiltritaj);
		btnFiltritaj.setOnAction(new FiltrirajController(this));
		e1_1_1.getChildren().add(cbMusko);
		e1_1_1.getChildren().add(cbZensko);
		e1_1.getChildren().add(lvTeniseri);
		lvTeniseri.getItems().addAll(Server.getInstance().getTeniseri());
		lvTeniseri.setMaxHeight(230);
		lvTeniseri.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		e1.getChildren().add(e1_2);
		e1_2.setAlignment(Pos.CENTER);
		e1_2.getChildren().add(btnKreirajMec);
		btnKreirajMec.setOnAction(new KreirajMecController(this));
		e1_2.getChildren().add(btnDodajIgrace);
		btnDodajIgrace.setOnAction(new DodajIgraceController(this));
		
		e1.getChildren().add(lvTereni);
		lvTereni.getItems().addAll(Server.getInstance().getTereni());
		lvTereni.setMaxHeight(250);
		lvTereni.setMaxWidth(100);
		
		
	}
	
	


	public TextField getTfIgrac() {
		return tfIgrac;
	}

	public CheckBox getCbMusko() {
		return cbMusko;
	}

	public CheckBox getCbZensko() {
		return cbZensko;
	}

	public TableView<Termini> getTvTermini() {
		return tvTermini;
	}

	public ListView<Teniseri> getLvTeniseri() {
		return lvTeniseri;
	}

	public ListView<Tereni> getLvTereni() {
		return lvTereni;
	}

	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		return instance;
	}

}

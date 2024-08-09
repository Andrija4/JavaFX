package view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Artikli;
import model.Server;

public class MainView extends Stage{
	
	private static MainView instance = null;
	
	private Scene scene;
	
	VBox root = new VBox(20);
	
	private MainView() {
		
		root.setAlignment(Pos.CENTER);
		
		scene = new Scene(root, 750, 600);
		
		createScene();
		
		setScene(scene);
		setTitle("OOP-JUN 2020");
		show();
	}
	
	
	
	
	
	private void createScene() {
	
		element1();
		element3();
		element4();
		
		root.getChildren().add(e1);
		root.getChildren().add(new Label("Sadrzaj korpe"));
		root.getChildren().add(tvArtikli);
		root.getChildren().add(e4);
	}
	//Element1
	HBox e1 = new HBox(15);
	TableView<Artikli> tvZanr = new TableView<Artikli>();
	
	RadioButton nove = new RadioButton("nove");
	RadioButton polovne = new RadioButton("polovne");
	RadioButton sve = new RadioButton("sve");
	
	Button prikazi = new Button("Prikazi");
	
	ListView<Artikli> lvArtikli = new ListView<Artikli>();
	
	List<Integer> kolicina = new ArrayList<Integer>();
	
	
	ComboBox<Integer> cbKolicina = new ComboBox<Integer>();
	
	Button dodajUKorpu = new Button("Dodaj u korpu");
	//Element3
	TableView<Artikli> tvArtikli = new TableView<Artikli>();
	//Element4
	HBox e4 = new HBox(5);
	Label racun = new Label("0");
	Button stampaj = new Button("Stampaj racun");


	private void element1() {
		e1.setAlignment(Pos.CENTER);
		e1.setPadding(new Insets(10));
		
		e1.getChildren().add(tvZanr);
		
		TableColumn<Artikli, String> tcZanr = new TableColumn<Artikli, String>("Zanr");
		tcZanr.setCellValueFactory(new PropertyValueFactory<>("zanr"));
		tvZanr.getColumns().add(tcZanr);
		
		TableColumn<Artikli, Integer> tcNovo = new TableColumn<Artikli, Integer>("Novo");
		tcNovo.setCellValueFactory(new PropertyValueFactory<>("mNovo"));
		tvZanr.getColumns().add(tcNovo);
		
		TableColumn<Artikli, Integer> tcPolovno = new TableColumn<Artikli, Integer>("Polovno");
		tcPolovno.setCellValueFactory(new PropertyValueFactory<>("mPolovno"));
		tvZanr.getColumns().add(tcPolovno);
		
		tvZanr.getItems().addAll(Server.getInstance().getArtikli());
		//tvZanr.setItems(FXCollections.observableArrayList(Server.getInstance().getArtikli()));
		
		
		GridPane gp1 = new GridPane();
		gp1.setAlignment(Pos.CENTER);
		gp1.setVgap(10);
		gp1.setHgap(5);
		
		gp1.add(nove, 0, 0);
		gp1.add(polovne, 1, 0);
		gp1.add(sve, 2, 0);
		gp1.add(prikazi, 1, 1);
		
		ToggleGroup tg = new ToggleGroup();
		nove.setToggleGroup(tg);
		polovne.setToggleGroup(tg);
		sve.setToggleGroup(tg);
		
		
		e1.getChildren().add(gp1);
		
		VBox vbKorpa = new VBox(5);
		vbKorpa.getChildren().add(lvArtikli);
		
		//3.2
		HBox hbKorpa = new HBox(5);
		hbKorpa.getChildren().add(new Label("Kolicina:"));
		
		kolicina.add(1);
		kolicina.add(2);
		kolicina.add(3);
		kolicina.add(4);
		kolicina.add(5);
		kolicina.add(6);
		kolicina.add(7);
		kolicina.add(8);
		kolicina.add(9);
		cbKolicina.setItems(FXCollections.observableArrayList((kolicina)));
		cbKolicina.setValue(cbKolicina.getItems().get(0));
		
		hbKorpa.getChildren().add(cbKolicina);
		hbKorpa.getChildren().add(dodajUKorpu);
		
		vbKorpa.getChildren().add(hbKorpa);
		//3
		e1.getChildren().add(vbKorpa);
		
	}



	private void element3() {
		tvArtikli.setMaxWidth(700);
		
		TableColumn<Artikli, String> tcArtikli = new TableColumn<Artikli, String>("Artikli");
		tcArtikli.setCellValueFactory(new PropertyValueFactory<>("nesto"));
		tvArtikli.getColumns().add(tcArtikli);
		
		tvArtikli.getItems().addAll(Server.getInstance().getArtikli());
		
		
	}

	


	private void element4() {
		e4.setAlignment(Pos.CENTER);
		e4.setPadding(new Insets(10));
		
		//stampaj.setOnAction(new Stampaj());
		
		e4.getChildren().add(new Label("Ukupno:"));
		e4.getChildren().add(racun);
		e4.getChildren().add(stampaj);
		
		
	}



	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		
		return instance;
	}

}

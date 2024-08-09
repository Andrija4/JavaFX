package view;

import javax.print.attribute.standard.Severity;

import controller.FiltritajController;
import controller.SacuvajController;
import controller.UpisiController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Vanzemaljac;

public class MainView extends Stage{
	
	private static MainView instance = null;

	private Scene scene;
	VBox root = new VBox(10);
	
	private MainView() {
		root.setAlignment(Pos.CENTER);
		scene = new Scene(root, 780, 500);
		
		createScene();
		
		setScene(scene);
		show();
	}
	
	//element1
	HBox e1 = new HBox(15);
	//e1_1
	VBox e1_1 = new VBox(5);
	//e1_1_1
	HBox e1_1_1 = new HBox(5);
	ComboBox<String> cbKontinent = new ComboBox<String>();
	CheckBox pronadjen = new CheckBox("Pronadjen");
	CheckBox izgubljen = new CheckBox("Izgubljen");
	Button filtriraj = new Button("Filtritaj");
	//e_1_1_2
	TableView<Vanzemaljac> tvVanzemaljac = new TableView<Vanzemaljac>();
	//e_1_2
	VBox e1_2 = new VBox(5);
	ComboBox<String> cbDrzava = new ComboBox<String>();
	Button btnUpisi = new Button("Upisi");
	Label poruka = new Label("Poruka");
	//element2
	Button btnSacuvaj = new Button("Sacuvaj");
	
	
	private void createScene() {
		element1();
		
		root.getChildren().add(e1);
		root.getChildren().add(btnSacuvaj);
		btnSacuvaj.setOnAction(new SacuvajController(this));
	}

	private void element1() {
		
		e1.setAlignment(Pos.CENTER);
		e1.getChildren().add(e1_1);
		e1.getChildren().add(e1_2);
		
		e1_1.setAlignment(Pos.CENTER);
		e1_1.setPadding(new Insets(10));
		e1_1.getChildren().add(e1_1_1);
		e1_1.getChildren().add(tvVanzemaljac);
		tvVanzemaljac.setMinWidth(600);
		
		TableColumn<Vanzemaljac, Integer> tcId = new TableColumn<Vanzemaljac, Integer>("ID");
		tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tvVanzemaljac.getColumns().add(tcId);
		
		TableColumn<Vanzemaljac, String> tcKontinent = new TableColumn<Vanzemaljac, String>("Kontinent");
		tcKontinent.setCellValueFactory(new PropertyValueFactory<>("kontinent"));
		tvVanzemaljac.getColumns().add(tcKontinent);
		
		TableColumn<Vanzemaljac, String> tcDrzava = new TableColumn<Vanzemaljac, String>("Drzava");
		tcDrzava.setCellValueFactory(new PropertyValueFactory<>("drzava"));
		tvVanzemaljac.getColumns().add(tcDrzava);
		
		tvVanzemaljac.getItems().addAll(Server.getInstance().getVanzemaljac());
		
		e1_1_1.setAlignment(Pos.CENTER);
		e1_1_1.getChildren().add(new Label("Kontinent"));
		e1_1_1.getChildren().add(cbKontinent);
		cbKontinent.setMinWidth(120);
		cbKontinent.getItems().add("Svi");
		cbKontinent.getItems().addAll(Server.getInstance().getKontinenti());
		cbKontinent.setValue(cbKontinent.getItems().get(0));
		e1_1_1.getChildren().add(pronadjen);
		e1_1_1.getChildren().add(izgubljen);
		e1_1_1.getChildren().add(filtriraj);
		filtriraj.setOnAction(new FiltritajController(this));
		
		e1_2.setAlignment(Pos.CENTER);
		e1_2.getChildren().add(new Label("Pronadjen"));
		e1_2.getChildren().add(cbDrzava);
		cbDrzava.setMinWidth(100);
		cbDrzava.getItems().addAll(Server.getInstance().getDrzave());
		cbDrzava.setValue(cbDrzava.getItems().get(0));
		e1_2.getChildren().add(btnUpisi);
		btnUpisi.setOnAction(new UpisiController(this));
		e1_2.getChildren().add(poruka);
		
	}
	
	

	public ComboBox<String> getCbKontinent() {
		return cbKontinent;
	}

	public CheckBox getPronadjen() {
		return pronadjen;
	}

	public CheckBox getIzgubljen() {
		return izgubljen;
	}

	public TableView<Vanzemaljac> getTvVanzemaljac() {
		return tvVanzemaljac;
	}

	public ComboBox<String> getCbDrzava() {
		return cbDrzava;
	}

	public Label getPoruka() {
		return poruka;
	}

	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		return instance;
	}
}

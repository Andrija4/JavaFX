package view;

 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Izvodjac;
import model.Server;
import model.Artikal;
import model.TipNosacaZvuka;

public class MainStage extends Stage{
	
	private static MainStage instance = null;
	
	private Scene scene;
	VBox root = new VBox(20);
	
	private MainStage() {
		
		
		root.setAlignment(Pos.CENTER);
		
		
		createView();
		
		scene = new Scene(root, 800, 800);
		
		setScene(scene);
		setTitle("OOP - JUN 2020");
		show();
		
	}
	
	//Element1
	HBox e1 = new HBox(15);
	ComboBox<Artikal> cbIzvodjaci = new ComboBox<>();
	RadioButton vinyl = new RadioButton("Vinyl");
	RadioButton cd = new RadioButton("CD");
	RadioButton vcd = new RadioButton("Vinyl i CD");
	
	//Element2
	HBox e2 = new HBox(15);
	ComboBox<String> cbVM = new ComboBox<>();
	TextField cena = new TextField();
	Button btnPrikazi = new Button("Prikazi sve");
	Button btnFilter = new Button("Filtriraj");
	
	//Element3
	TableView<Artikal> tvArtikli = new TableView<>();
	
	//Element4
	Button izaberi = new Button("Izaberi");

	//Element 5
	HBox e5 = new HBox(20);
	ListView<Izvodjac> lvArtikli = new ListView<Izvodjac>();
	TextField tfUkupno = new TextField();
	Button kupi = new Button("Kupi");
	Button mojaKolekcija = new Button("Moja Kolekcija");
	
	
	private void createView() {

		element1();
		element2();
		element3();
		element5();
		
		root.getChildren().add(e1);
		root.getChildren().add(e2);
		root.getChildren().add(tvArtikli);
		root.getChildren().add(izaberi);
		root.getChildren().add(e5);
		
	}

	private void element5() {
		e5.setAlignment(Pos.CENTER);
		
		e5.getChildren().add(lvArtikli);
		
		GridPane gp = new GridPane();
		gp.setHgap(15);
		gp.setVgap(20);
		gp.setAlignment(Pos.CENTER);
		gp.add(new Label("Ukupno kosta: "), 0, 0);
		gp.add(tfUkupno, 1, 0);
		gp.add(kupi, 0, 1);
		gp.add(mojaKolekcija, 1, 1);
		
		e5.getChildren().add(gp);
		
	}

	private void element2() {

		e2.setAlignment(Pos.CENTER);
		
		e2.getChildren().add(new Label("Cena"));
		
		e2.getChildren().add(cbVM);
		cbVM.getItems().addAll(">", "<", "=");
		cbVM.setValue(cbVM.getItems().get(0));
		
		e2.getChildren().add(cena);
		e2.getChildren().add(btnPrikazi);
		e2.getChildren().add(btnFilter);
	}

	private void element3() {
		
		
		TableColumn<Artikal, Izvodjac> tcIzvodjac = new TableColumn<Artikal, Izvodjac>("Izvodjaci");
		tcIzvodjac.setCellValueFactory(new PropertyValueFactory<>("izvodjac"));
		tvArtikli.getColumns().add(tcIzvodjac);
		
		TableColumn<Artikal, String> tcNaziv = new TableColumn<Artikal, String>("Naziv");
		tcNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
		tvArtikli.getColumns().add(tcNaziv);
		
		TableColumn<Artikal, Integer> tcGodina = new TableColumn<Artikal, Integer>("Godina");
		tcGodina.setCellValueFactory(new PropertyValueFactory<>("godina"));
		tvArtikli.getColumns().add(tcGodina);
		
		TableColumn<Artikal, String> tcZanr = new TableColumn<Artikal, String>("Zanr");
		tcZanr.setCellValueFactory(new PropertyValueFactory<>("zanr"));
		tvArtikli.getColumns().add(tcZanr);
		
		TableColumn<Artikal, TipNosacaZvuka> tcTip = new TableColumn<Artikal, TipNosacaZvuka>("Tip");
		tcTip.setCellValueFactory(new PropertyValueFactory<>("tip"));
		tvArtikli.getColumns().add(tcTip);
		
		TableColumn<Artikal, Integer> tcKomad = new TableColumn<Artikal, Integer>("Komad");
		tcKomad.setCellValueFactory(new PropertyValueFactory<>("komad"));
		tvArtikli.getColumns().add(tcKomad);
		
		TableColumn<Artikal, Integer> tcCena = new TableColumn<Artikal, Integer>("Cena");
		tcCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
		tvArtikli.getColumns().add(tcCena);
		
		TableColumn<Artikal, String> tcKategorija = new TableColumn<Artikal, String>("Kategorija");
		tcKategorija.setCellValueFactory(new PropertyValueFactory<>("kategorija"));
		tvArtikli.getColumns().add(tcKategorija);
		
		tvArtikli.getItems().addAll(Server.getInstance().getArtikli());
		
	}

	private void element1() {
		
		e1.setAlignment(Pos.CENTER);
		
		e1.getChildren().add(new Label("Izvodjac: "));
		e1.getChildren().add(cbIzvodjaci);
		e1.getChildren().add(vinyl);
		e1.getChildren().add(cd);
		e1.getChildren().add(vcd);
		
		cbIzvodjaci.getItems().addAll(Server.getInstance().getIzvodjaci());
		if(Server.getInstance().getIzvodjaci().size() != 0) {
			cbIzvodjaci.setValue(cbIzvodjaci.getItems().get(0));
		}
		
		ToggleGroup tg = new ToggleGroup();
		vinyl.setToggleGroup(tg);
		cd.setToggleGroup(tg);
		vcd.setToggleGroup(tg);
	
	}

	public static MainStage getInstance() {
		if(instance == null)
			instance = new MainStage();
		
		return instance;
	}
	
}

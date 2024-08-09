package view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Server;
import model.Studenti;
import model.Termini;
import model.Ucionice;


public class Dodeljivanje extends Stage{
	private static Dodeljivanje instance = null;
	
	private Scene scene2;
	VBox root = new VBox(10);
	
	
	private Dodeljivanje() {
		root.setAlignment(Pos.CENTER);
		
		createScene2();
		
		scene2 = new Scene(root, 650, 700);
		setScene(scene2);
		setTitle("");
		show();
	}
	
	//Element 1
	HBox e1 = new HBox(30);
	
	VBox e1_1 = new VBox(10);
	HBox e1_1_1 = new HBox(5);
	Label brojNeStud = new Label("0");
	ListView<Studenti> lvStudenti= new ListView<Studenti>();
	
	Button dodeli = new Button("Dodeli");
	
	VBox e1_2 = new VBox(10);
	HBox e1_2_1 = new HBox(5);
	ComboBox<Termini> cbTermini = new ComboBox<Termini>();
	Button ucitaj = new Button("Učitaj termin");
	ListView<Ucionice> lvUcionice = new ListView<Ucionice>();
		
	//Element 2
	TableView<Studenti> tvStudenti = new TableView<Studenti>();
	
	//Element 3
	Button snimi = new Button("Snimi");
	
	private void createScene2() {
		element1();
		element2();
		
		root.getChildren().add(e1);
		root.getChildren().add(tvStudenti);
		root.getChildren().add(snimi);
		
	}




	private void element1() {
		
		e1.setAlignment(Pos.CENTER);
		e1.getChildren().add(e1_1);
		
		e1_1.setAlignment(Pos.CENTER);
		
		e1_1.getChildren().add(e1_1_1);
		e1_1_1.setAlignment(Pos.CENTER);
		e1_1_1.getChildren().add(new Label("Broj neraspoređenih studenata:"));
		e1_1_1.getChildren().add(brojNeStud);
		
		e1_1.getChildren().add(lvStudenti);
		lvStudenti.getItems().addAll(Server.getInstance().getStudenti());
		
		e1.getChildren().add(dodeli);
		
		e1.getChildren().add(e1_2);
		
		e1_2.setAlignment(Pos.CENTER);
		e1_2.getChildren().add(e1_2_1);
		
		e1_2_1.setAlignment(Pos.CENTER);
		e1_2_1.getChildren().add(cbTermini);
		e1_2_1.getChildren().add(ucitaj);
		
		e1_2.getChildren().add(lvUcionice);
		lvUcionice.getItems().addAll(Server.getInstance().getUcionice());
		
		
		
		
	}




	private void element2() {
		tvStudenti.setMaxWidth(630);
		
		TableColumn<Studenti, String> tcStudenti = new TableColumn<Studenti, String>("Student");
		tcStudenti.setCellValueFactory(new PropertyValueFactory<>("nesto"));
		tvStudenti.getColumns().add(tcStudenti);
		
		TableColumn<Studenti, Termini> tcTermini = new TableColumn<Studenti, Termini>("Termin");
		tcStudenti.setCellValueFactory(new PropertyValueFactory<>(""));
		tvStudenti.getColumns().add(tcTermini);

		TableColumn<Studenti, Ucionice> tcUcionice = new TableColumn<Studenti, Ucionice>("Ucionice");
		tcStudenti.setCellValueFactory(new PropertyValueFactory<>(""));
		tvStudenti.getColumns().add(tcUcionice);
		
		tvStudenti.getItems().addAll(Server.getInstance().getStudenti());
	}




	public static Dodeljivanje getInstance() {
		if(instance == null)
			instance = new Dodeljivanje();
		return instance;
	}

}

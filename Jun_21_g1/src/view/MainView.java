package view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Stage{
	private static MainView instance = null;
	
	private Scene scene;
	VBox root = new VBox(10);
	
	
	private MainView() {
		
		root.setAlignment(Pos.CENTER);
		
		createScene();
		
		scene = new Scene(root, 400, 400);
		setScene(scene);
		setTitle("");
		show();
	}
	
	
	//grid
	GridPane gp = new GridPane();
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	
	//check
	HBox hb = new HBox(5);
	CheckBox cb = new CheckBox();
	//pokreni
	Button pokreni = new Button("Pokreni");
	//poruka
	Label poruka = new Label("Poruka");
	
	private void createScene() {
		
		grid();
		check();
		pokreni();
		
		root.getChildren().add(new Label("Unesite potrebne podatke za raspodelu"));
		root.getChildren().add(gp);
		root.getChildren().add(hb);
		root.getChildren().add(pokreni);
		root.getChildren().add(poruka);
		
	}



	private void pokreni() {

		pokreni.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				Dodeljivanje.getInstance();
			}
		});
		
	}



	private void check() {
		hb.setAlignment(Pos.CENTER);
		
		hb.getChildren().add(cb);
		hb.getChildren().add(new Label("samo učionice sa računarima"));
	}



	private void grid() {
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		
		gp.add(new Label("Broj termina"), 0, 0);
		gp.add(tf1, 1, 0);
		gp.add(new Label("Broj studenata u ucionici"), 0, 1);
		gp.add(tf2, 1, 1);
		
	}



	public static MainView getInstance() {
		if(instance == null)
			instance = new MainView();
		return instance;
	}

}

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Server;
import view.MainStage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		
		Server.getInstance();
		
		MainStage.getInstance();
		
	
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}

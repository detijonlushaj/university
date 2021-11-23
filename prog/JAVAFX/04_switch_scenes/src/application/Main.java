package application;
	
import javafx.application.Application;

import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		    Scene1.setLayout(primaryStage);
            Scene2.setLayout(primaryStage);
	        	     	         	         
            Scene1.switchScene(Scene2.getScene());
            Scene2.switchScene(Scene1.getScene());    
            	         
	        primaryStage.setTitle("test scene switches");
	        primaryStage.setScene(Scene1.getScene());   
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
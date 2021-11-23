package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400, Color.BLACK);
			
			
			primaryStage.setTitle("test stage");	
			Image icon = new Image("icon.png");
			primaryStage.getIcons().add(icon);
			primaryStage.setHeight(420);
			primaryStage.setWidth(420);
			// primaryStage.setResizable(false);
			// primaryStage.setFullScreen(false);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
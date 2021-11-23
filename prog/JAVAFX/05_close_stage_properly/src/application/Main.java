package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
    static boolean check; 

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			Button button = new Button("close window");
			root.setCenter(button);
			
			primaryStage.setOnCloseRequest(e -> {
			    e.consume();  // otherwise window would close anyway
			    closeWindow(primaryStage);
			});
			button.setOnAction(e -> closeWindow(primaryStage));
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void closeWindow(Stage stage) {
	    Stage checkWindow = new Stage();
	    	    
	    Label label = new Label("are you sure you want to close the program?");
	    Button btnNo = new Button("No");
	    Button btnYes = new Button("Yes");
	    
	    HBox hbox = new HBox(10);
	    hbox.getChildren().addAll(btnYes, btnNo);
	    VBox root = new VBox(10);
	    root.getChildren().addAll(label, hbox);
	    
	    btnNo.setOnAction(e -> {
	        check = false; 
	        checkWindow.close();
	    });
	    btnYes.setOnAction(e -> {
	        check = true; 
	        checkWindow.close();
	        stage.close();
	    });
	    
	    
	    Scene checkScene = new Scene(root);
	    checkWindow.setScene(checkScene);
	    checkWindow.show();
	}
}
package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
/**
 * main class to start the home scene
 * @author lushaj
 *
 */
public class Main extends Application {
    private final static int WIDTH = 800;
    private final static int HEIGHT = 500;
    
    /**
     * Start the Main-Home Screen
     */
    @Override
    public void start(Stage stage) {L
        try {            
            stage = setStage(stage);
            Home.setLayout(stage);
            Home.setEvents();
            stage.setResizable(false);
                        
            stage.setScene(Home.getScene());
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * set the Home screen
     * @param stage
     * @param s
     * @return
     */
    public static Stage setStage(Stage stage) {
        stage.setTitle("THE WORLD HARDEST GAME");
        stage.getIcons().add(new Image("/lushaj_res/icon.png"));
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        return stage;
    }
    /**
     * geht the size of the stage
     * @return
     */
    public static int[] getSize() {
        return new int[] {WIDTH, HEIGHT};
    }
    /**
     * main launch
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
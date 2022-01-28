package application;
	
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 
 * @author Schehat
 * client program to start the game
 */
public class Main extends Application {
    private static double WIDTH = 800.0;
    private static double HEIGHT = 600.0;
    private static String GAME_TITLE = "CONSTRUCT";
    private static String ICON_NAME = "neo.png";
    
    /**
     *  stage control & setup of StartScene
     */
	@Override
	public void start(Stage stage) {
		try {
		    stage = setStage(stage);
		    stage.setResizable(false);
		    
		    StartScene.setStage(stage);
		    StartScene.setLayout();
		    StartScene.setEvents();
					    
            stage.setScene(StartScene.getScene());
            stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * customizing the stage
	 * @param stage
	 * @return stage
	 */
	public static Stage setStage(Stage stage) {
        stage.setTitle(GAME_TITLE); 
        Image icon = new Image(ICON_NAME);
        stage.getIcons().add(icon);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        return stage;
	}
	
	/**
	 * 
	 * @return height & width of stage
	 */
	public static double[] getSize() {
	    return new double[] {WIDTH, HEIGHT};
	}
	
	/**
	 * runs in the background the start method  
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
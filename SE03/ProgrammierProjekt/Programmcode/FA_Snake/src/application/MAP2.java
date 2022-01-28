package application;

import java.util.ArrayList;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * 
 * @author Fugy
 *
 */
public class MAP2  {
	private static Stage stage;
	private static BorderPane root = new BorderPane();
	private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);

	private static boolean setup = true;
	private static Timeline tl1; 


	private static boolean left = false;
	private static boolean down = false;
	private static boolean up = false;
	private static boolean right = true;

	private static Random rand = new Random();
	private static boolean eaten = false;

	private static Image snake = new Image("Fugy_res/smith.png");
	private static ArrayList<ImageView> smith = new ArrayList<>();

	private static Image foodP = new Image("Fugy_res/morpheus.png");
	private static ImageView  morpheus = new ImageView(foodP);

	private static int counter = 0;


	private static int cnt = 0;

	private static ArrayList<Rectangle> obstacle = new ArrayList<Rectangle>();

	/**
	 * Set the Layout for MAP2
	 */

	public static void setLayout() {
		//Timeline for gameloop
		tl1 = new Timeline(new KeyFrame(Duration.millis(Home.getSpeed()),e -> gameloop()));
		
		//Backgroung
		Image Background = new Image("Fugy_res/home_bg.gif");
		ImageView home_bg = new ImageView(Background);
		home_bg.setFitHeight(600);
		home_bg.setFitWidth(600);
		home_bg.setX(0.0);
		home_bg.setY(0.0);
		root.getChildren().add(home_bg);

		//root
		VBox vboxeif = new VBox(); 
		vboxeif.getChildren().addAll(home_bg);
		root.setCenter(vboxeif);


		gameloop();
		scene.setOnKeyPressed(e -> {
			if (e.getCode().equals(KeyCode.LEFT) || e.getCode().equals(KeyCode.A)) {
				left = true;
				right = false;
				up = false;
				down = false;
			}
			if (e.getCode().equals(KeyCode.RIGHT) || e.getCode().equals(KeyCode.D))   {
				left = false;
				right = true;
				up = false;
				down = false;
			}
			if (e.getCode().equals(KeyCode.UP) || e.getCode().equals(KeyCode.W)) {
				left = false;
				right = false;
				up = true;
				down = false;
			}
			if (e.getCode().equals(KeyCode.DOWN) || e.getCode().equals(KeyCode.S)) {
				left = false;
				right = false;
				up = false;
				down = true;
			}});
	}


	/**
	 * gameloop
	 */
	public static void gameloop() {
		cnt++;
		if(checkCollision2()) {
			tl1.stop();
			stage.setScene(GameOver.getScene());
            GameOver.setLayout();
		}

		if(setup) {
			setup = false; 
			tl1.setCycleCount(Timeline.INDEFINITE);
			tl1.playFromStart();
			smith.add(new ImageView(snake));
			smith.get(0).setFitHeight(40);
			smith.get(0).setFitWidth(40);
			obstacle.add(new Rectangle(100,100,50,30));
			obstacle.add(new Rectangle(300,150,70,20));
			obstacle.add(new Rectangle(40,400,50,50));
			obstacle.add(new Rectangle(230,200,50,30));
			obstacle.add(new Rectangle(360,400,30,80));
			for(int i = 0; i<5; i++) {
				obstacle.get(i).setFill(Color.GRAY);
			}
			root.getChildren().addAll(smith.get(0),morpheus,obstacle.get(0),obstacle.get(1),obstacle.get(2),obstacle.get(3),obstacle.get(4));
		}
		if(checkCollision3()) {
			tl1.stop();
			stage.setScene(GameOver.getScene());
            GameOver.setLayout();
		}
		if(checkCollision4()) {
			tl1.stop();
			stage.setScene(GameOver.getScene());
            GameOver.setLayout();
		}
		//movement of snake
		if(right) {
			smith.get(0).setX(smith.get(0).getX()+1);
		}
		if(left) {
			smith.get(0).setX(smith.get(0).getX()-1);
		}
		if(up) {
			smith.get(0).setY(smith.get(0).getY()-1);
		}
		if(down) {
			smith.get(0).setY(smith.get(0).getY()+1);
		}
		//delay for following snake body
		if(cnt==50) {
			for(int i = counter; i>0; i--) {
				smith.get(i).setX(smith.get(i-1).getX());
				smith.get(i).setY(smith.get(i-1).getY());
			}
			cnt = 0;
		}

		if(!eaten) {
			morpheus.setFitWidth(55);
			morpheus.setFitHeight(55);
			morpheus.setX(rand.nextInt(500));
			morpheus.setY(rand.nextInt(500));
			eaten = true;
		}
		if(checkCollision()) {
			eaten = false;
			counter++;
			Home.setCounter(counter);
			smith.add(new ImageView(snake));
			smith.get(counter).setFitHeight(40);
			smith.get(counter).setFitWidth(40);
			smith.get(counter).setX(-100);
			smith.get(counter).setY(-100);
			root.getChildren().addAll(smith.get(counter));
		}


	}

	/**
	 * eating food
	 * @return boolean
	 */
	public static boolean checkCollision() {
		if (smith.get(0).getBoundsInParent().intersects(morpheus.getBoundsInParent())) {
			Sound.reset_eat();
			Sound.eat();
			return true;
		}
		return false;
	}

	/**
	 * collision with obstacle
	 * @return boolean
	 */
	public static boolean checkCollision2() {
		for (int i =0; i<smith.size(); i++) {
			for(int j = 0; j<5; j++) {
				if(smith.get(i).getBoundsInParent().intersects(obstacle.get(j).getBoundsInParent())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * limiting game area
	 * @return boolean
	 */
	public static boolean checkCollision3() {
		if( smith.get(0).getX() < -5){
			return true;
		}
		if(  smith.get(0).getX() > 600-42 ){
			return true;
		}
		if( ( smith.get(0).getY() < -5 )){
			return true;
		}
		if( smith.get(0).getY() > 600-42 ){
			return true;
		}
		return false;
	}
	
	/**
	 * collision with himself
	 * @return boolean
	 */
	public static boolean checkCollision4() {
		for(int i=3; i<smith.size(); i++) {
			if (smith.get(0).getBoundsInParent().intersects(smith.get(i).getBoundsInParent())) {
				return true;
			}
		}
		return false;
	}
	

	public static void setEvents() {
	}

	/**
	 * 
	 * @return Scene
	 */
	public static Scene getScene() {
		return MAP2.scene;
	}

	/**
	 * 
	 * @param stage
	 */
	public static void setStage(Stage stage) {
		MAP2.stage = stage;
	}
}
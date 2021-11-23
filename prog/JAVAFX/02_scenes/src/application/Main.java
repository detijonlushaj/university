package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400, Color.SKYBLUE);

			Text text = new Text();
			text.setText("i am here!");
			// need to specify coordinates due to using group as scene
			text.setX(50);
	        text.setY(50);
	        text.setFont(Font.font("TimesRoman", 30));
			text.setFill(Color.RED);
			
			Line line = new Line();
			line.setStartX(50);
			line.setStartY(50);
			line.setEndX(150);
			line.setEndY(150);
			line.setStrokeWidth(3);
			line.setStroke(Color.WHITE);
			line.setRotate(12);
			
			Rectangle rect = new Rectangle();
			rect.setX(150);
			rect.setY(150);
			rect.setHeight(75);
			rect.setWidth(75);
			rect.setFill(Color.GREEN);
			rect.setStrokeWidth(3);
			rect.setStroke(Color.BLACK);
			
			Polygon triangle = new Polygon();
			triangle.getPoints().addAll(new Double[]{
			        380.0, 380.0,
			        300.0, 380.0,
			        350.0, 350.0});
			triangle.setFill(Color.YELLOW);
			
			Circle circle = new Circle();
			circle.setCenterX(50);
			circle.setCenterY(350);
			circle.setRadius(30);
			circle.setFill(Color.ORANGE);
			
			Image image = new Image("controller.png");
			ImageView imageview = new ImageView(image);
			imageview.setX(150.0);
			imageview.setY(250.0);
			
	        root.getChildren().addAll(text, line, rect, triangle, circle, imageview);
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
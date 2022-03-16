package application;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver {
	private static BorderPane root = new BorderPane();
	private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);

	private static Label lbl = new Label();
	private static  HBox hbox = new HBox();

	private static Font lbl_font = Font.font("Courier New", FontWeight.BOLD, 30);

	/**
	 * Sets the Layout for GameOver
	 */
	public static void setLayout() {
		Image Background = new Image("Fugy_res/home_bg.gif");
		ImageView home_bg = new ImageView(Background);
		home_bg.setFitHeight(600);
		home_bg.setFitWidth(600);
		home_bg.setX(0.0);
		home_bg.setY(0.0);
		root.getChildren().add(home_bg);

		lbl.setText("Game Over!\n Your score: "+ Home.getCounter());
		lbl.setFont(lbl_font);
		lbl.setTextFill(Color.web("#FFFFFF"));

		hbox.getChildren().addAll(lbl);
		hbox.setPadding(new Insets(250, 0, 0, 140));

		VBox vboxeif = new VBox(); 
		vboxeif.getChildren().addAll(hbox);
		root.setCenter(vboxeif);
	}

	public static void setEvents() {

	}
	/**
	 * 
	 * @return Scene
	 */
	public static Scene getScene() {
		return GameOver.scene;
	}
}

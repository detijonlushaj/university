package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * 
 * @author Fugy
 *
 */
public class Home {
	private static Stage stage;
	private static BorderPane root = new BorderPane();
	private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
	private static Label lbl_start = new Label();
	private static Label lbl_dif = new Label();
	private static HBox hbox_lbl_dif = new HBox();
	private static HBox hboxlbl_start= new HBox();
	private static Button btn_E = new Button();
	private static Button btn_M = new Button();
	private static Button btn_H = new Button();
	private static Button btn_beg = new Button();
	private static HBox hbox_btn_beg = new HBox();
	private static HBox hbox_btn_Sch = new HBox();
	private static HBox hbox_btn_Ob = new HBox();
	private static HBox hbox_lbl_Ob = new HBox();
	private static Label lbl_lvl = new Label();
	private static Button btn_On = new Button();
	private static Button btn_Off = new Button();
	private static boolean Off = false;
	private static boolean On = false;
	private static int speed;
	private static int counter;
	/**
	 * sets the Layout
	 * @param stage
	 */
	 public static void setLayout(Stage stage) {
		 Home.stage = stage;

		 //Background
		 Image Background = new Image("Fugy_res/home_bg.gif");
		 ImageView home_bg = new ImageView(Background);
		 home_bg.setFitHeight(600);
		 home_bg.setFitWidth(600);
		 home_bg.setX(0.0);
		 home_bg.setY(0.0);
		 root.getChildren().addAll(home_bg);

		 Font btn_font = Font.font("Courier New", FontWeight.BOLD, 25);  //FRONT 4LEVEL
		 Font lbl_font = Font.font("Courier New", FontWeight.BOLD, 30);  //FRONT 4LEVEL


		 //lbl_start
		 lbl_start.setText("Welcome to Matrix's Snake.");
		 lbl_start.setFont(lbl_font);
		 lbl_start.setTextFill(Color.web("#FFFFFF"));

		 //lbl_dif
		 lbl_dif.setText("Pick your difficulty!");
		 lbl_dif.setFont(lbl_font);
		 lbl_dif.setTextFill(Color.web("#FFFFFF"));

		 //Button easy
		 btn_E.setText("Easy");
		 btn_E.setFont(btn_font);
		 btn_E.setPrefSize(140, 30);
		 btn_E.setStyle( "-fx-background-color: #0000FF; "
				 + " -fx-base: Black");

		 //Button Medium
		 btn_M.setText("Medium");
		 btn_M.setFont(btn_font);
		 btn_M.setPrefSize(140, 30);
		 btn_M.setStyle( "-fx-background-color: #0000FF; "
				 + " -fx-base: Black");

		 //Button Hard
		 btn_H.setText("Hard");
		 btn_H.setFont(btn_font);
		 btn_H.setPrefSize(140, 30);
		 btn_H.setStyle( "-fx-background-color: #0000FF; "
				 + " -fx-base: Black");

		 //lbl_level
		 lbl_lvl.setText("Turn ON/OFF obstacles.");
		 lbl_lvl.setFont(lbl_font);
		 lbl_lvl.setTextFill(Color.web("#FFFFFF"));

		 //Button ON for obstacles
		 btn_On.setText("ON");
		 btn_On.setFont(btn_font);
		 btn_On.setPrefSize(140, 30);
		 btn_On.setStyle( "-fx-background-color: #FF0000; "
				 + " -fx-base: White");

		 //Button OFF for obstacles
		 btn_Off.setText("OFF");
		 btn_Off.setFont(btn_font);
		 btn_Off.setPrefSize(140, 30);
		 btn_Off.setStyle( "-fx-background-color: #FF0000; "
				 + " -fx-base: White");

		 //Button Begin
		 btn_beg.setText("Begin!");
		 btn_beg.setFont(btn_font);
		 btn_beg.setPrefSize(200, 50);
		 btn_beg.setStyle( "-fx-background-color: #006d00; "
				 + " -fx-base: Black");


		 //lbl1 hbox
		 hboxlbl_start.getChildren().addAll(lbl_start);
		 hboxlbl_start.setPadding(new Insets(20, 0, 10, 50));

		 hbox_lbl_dif.getChildren().addAll(lbl_dif);
		 hbox_lbl_dif.setPadding(new Insets(40, 0, 0, 50));

		 //btn1 hbox
		 hbox_btn_Sch.getChildren().addAll(btn_E, btn_M, btn_H);
		 hbox_btn_Sch.setPadding(new Insets(20, 0, 10, 40));
		 hbox_btn_Sch.setSpacing(40);

		 //lbl3 hbox
		 hbox_lbl_Ob.getChildren().addAll(lbl_lvl);
		 hbox_lbl_Ob.setPadding(new Insets(40, 0, 0, 50));

		 //btn2 hbox
		 hbox_btn_Ob.getChildren().addAll(btn_On, btn_Off);
		 hbox_btn_Ob.setPadding(new Insets(20, 0, 60, 120));
		 hbox_btn_Ob.setSpacing(40);

		 //btn3 hbox
		 hbox_btn_beg.getChildren().addAll(btn_beg);
		 hbox_btn_beg.setPadding(new Insets(20, 0, 0, 180));
		 hbox_btn_beg.setSpacing(40);



		 //root
		 VBox vboxeif = new VBox(); 
		 vboxeif.getChildren().addAll(hboxlbl_start, hbox_lbl_dif, hbox_btn_Sch,
				 hbox_lbl_Ob, hbox_btn_Ob, hbox_btn_beg);
		 root.setCenter(vboxeif);
	 }
	 /**
	  * set up all events in the start scene
	  */
	 public static void setEvents() {

		 btn_beg.setDisable(true);
		 btn_E.setOnAction(e -> {
			 Sound.reset_startB();
			 Sound.startB();
			 btn_M.setDisable(true);
			 btn_H.setDisable(true);
			 setSpeed(10);
		 });

		 btn_M.setOnAction(e -> {
			 Sound.reset_startB();
			 Sound.startB();
			 btn_E.setDisable(true);
			 btn_H.setDisable(true);
			 setSpeed(6);
		 });

		 btn_H.setOnAction(e -> {
			 Sound.reset_startB();
			 Sound.startB();
			 btn_E.setDisable(true);
			 btn_M.setDisable(true);
			 setSpeed(3);
		 });
		 btn_On.setOnAction(e -> {
			 Sound.reset_startB();
			 Sound.startB();
			 btn_Off.setDisable(true);
			 btn_beg.setDisable(false);
			 On = true;

		 });

		 btn_Off.setOnAction(e -> {
			 Sound.reset_startB();
			 Sound.startB();
			 btn_On.setDisable(true);
			 btn_beg.setDisable(false);
			 Off = true;

		 });



		 btn_beg.setOnAction(e -> {

			 Sound.reset_startB();
			 Sound.startB();
			 if(On) {
				 stage.setScene(MAP2.getScene());
				 MAP2.setLayout();
				 MAP2.setStage(stage);
			 } else if (Off) {
				 stage.setScene(MAP1.getScene());
				 MAP1.setLayout();
				 MAP1.setStage(stage);
			 }
		 });
	 }
	 
	 /**
	  * 
	  * @param n
	  */
	 public static void setSpeed(int n) {
		 speed = n;
	 }
	 /**
	  * 
	  * @param n
	  */
	 public static void setCounter(int n) {
		 counter = n;
	 }
	 /**
	  * 
	  * @return counter
	  */
	 public static int getCounter() {
		 return counter;
	 }
	 /**
	  * 
	  * @return speed
	  */
	 public static int getSpeed() {
		 return speed;
	 }
	 /**
	  * 
	  * @return Home.scene
	  */
	 public static Scene getScene() {
		 return Home.scene;
	 }
	 /**
	  * 
	  * @param stage
	  */
	 public static void setStage(Stage stage) {
		 Home.stage = stage;

	 }
}
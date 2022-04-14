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
 * Home Secne where you choose your settings
 * @author lushaj
 */
public class Home {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static Button level1 = new Button();
    private static Button btn_medium = new Button();
    private static Button btn_hard = new Button();
    private static Label lbl_home = new Label();
    private static Label lbl_home2 = new Label();
    private static Label lbl_goodluck = new Label();
    private static HBox hboxlbl1= new HBox();
    private static HBox hbox_btn_speed= new HBox(); 
    private static HBox hboxlbl2= new HBox(); 
    private static HBox hbox_btn_lvl= new HBox(); 
    private static HBox hbox_btn_gl= new HBox();
    private static double speed;
    private static double e_speed;
    private static int death;
 
    /**
     * sets the Layout
     * @param stage
     */
    public static void setLayout(Stage stage) {
        Home.stage = stage;

        //Backgroung for Home
        Image Background = new Image("/lushaj_res/home_bg.gif");
        ImageView home_bg = new ImageView(Background);
        home_bg.setFitHeight(500);
        home_bg.setFitWidth(800);
        home_bg.setX(0.0);
        home_bg.setY(0.0);
        root.getChildren().addAll(home_bg);

        //Minecraft Meme
        Image minecraft_men = new Image("/lushaj_res/minecraft_men.png");
        ImageView men_minecraft = new ImageView(minecraft_men);
        men_minecraft.setX(530);
        men_minecraft.setY(200);
        root.getChildren().addAll(men_minecraft);

        Font btn_font = Font.font("Courier New", FontWeight.BOLD, 25);  //FRONT 4LEVEL
        Font lbl_font = Font.font("Courier New", FontWeight.BOLD, 30);  //FRONT 4LEVEL
        Font lbl_luck = Font.font("Courier New", FontWeight.BOLD, 20);  //FRONT 4hardness


        //set labels and buttons
        lbl_home.setText("Hello and Welcome to the Matrix World \n"
                + "please choose your degree of hardness");
        lbl_home.setFont(lbl_font);
        lbl_home.setTextFill(Color.web("#FFFFFF"));

        //degree of hardness    
        btn_medium.setText("MEDIUM");
        btn_medium.setFont(btn_font);
        btn_medium.setPrefSize(170, 30);
        btn_medium.setStyle( "-fx-background-color: #006d00; "
                + " -fx-base: White");

        btn_hard.setText("HARD");
        btn_hard.setFont(btn_font);
        btn_hard.setPrefSize(170, 30);
        btn_hard.setStyle( "-fx-background-color: #006d00; "
                + " -fx-base: White");

        lbl_home2.setText("Press Start");
        lbl_home2.setFont(lbl_font);
        lbl_home2.setTextFill(Color.web("#FFFFFF"));

        //lvl1      
        level1.setText("LEVEL 1");
        level1.setFont(btn_font);
        level1.setPrefSize(140, 30);

        level1.setStyle( "-fx-background-color: #006d00; "
                + " -fx-base: White");

        lbl_goodluck.setText("-GOOD-LUCK-");
        lbl_goodluck.setFont(lbl_luck);
        lbl_goodluck.setTextFill(Color.web("#FFFFFF"));

        //btn hbox
        hboxlbl1.getChildren().addAll(lbl_home);
        hboxlbl1.setPadding(new Insets(25, 0, 0, 50));

        //btn hbox
        hbox_btn_speed.getChildren().addAll(btn_medium,btn_hard);
        hbox_btn_speed.setPadding(new Insets(25, 0, 0, 50));
        hbox_btn_speed.setSpacing(30);

        //btn hbox
        hboxlbl2.getChildren().addAll(lbl_home2);
        hboxlbl2.setPadding(new Insets(25, 0, 0, 50));


        //btn hbox
        hbox_btn_lvl.getChildren().addAll(level1); 
        hbox_btn_lvl.setPadding(new Insets(25, 0, 0, 50));
        hbox_btn_lvl.setSpacing(30);

        //btn goodluck 
        hbox_btn_gl.getChildren().addAll(lbl_goodluck);
        hbox_btn_gl.setPadding(new Insets(25, 0, 0, 50));
        hbox_btn_gl.setSpacing(30);

        //startzustand
        defaultwerte();

        //root
        VBox vboxeif = new VBox(); 
        vboxeif.getChildren().addAll(hboxlbl1, hbox_btn_speed, hboxlbl2, hbox_btn_lvl, hbox_btn_gl);
        root.setCenter(vboxeif);
    }
    /**
     * set up all events in the start scene
     */
    public static void setEvents() {
        level1.setOnMouseEntered(e -> level1.setText("-START-"));
        level1.setOnMouseExited(e -> level1.setText("START"));

        btn_medium.setOnAction(e -> {
            Sounds.reset_check();
            Sounds.check();
            hboxlbl2.setVisible(true);
            hbox_btn_lvl.setVisible(true);
            hbox_btn_gl.setVisible(true);
            lbl_goodluck.setText("-GOOD-LUCK- \n\n-MEDIUM-");
            btn_medium.setText("-MEDIUM-");
            btn_hard.setText("HARD");
            speed = 1.2;
            e_speed = 1;
            death =0;
        });
        btn_hard.setOnAction(e -> {
            Sounds.reset_check();
            Sounds.check();
            hboxlbl2.setVisible(true);
            hbox_btn_lvl.setVisible(true);
            hbox_btn_gl.setVisible(true);
            btn_hard.setText("-HARD-");
            btn_medium.setText("MEDIUM");
            lbl_goodluck.setText("-GOOD-LUCK- \n\n-HARD-");
            
            speed = 1;
            e_speed = 1.6;
            death =0;
        });

        level1.setOnAction(e -> {
            Sounds.reset_check();
            Sounds.check();
            if(!LVL1.getCheck()) {
                LVL1.setLayout();
                LVL1.setEvents();
            } 
            LVL1.setStage(stage);
            LVL1.startGame();
            stage.setScene(LVL1.getScene());
            LVL1.setCheck();
        });
    }
    /** 
     * get speed
     * @param x
     */
    public static double getSpeed() {
        return speed;
    }
    /**
     * get speed
     * @param x
     */
    public static double geteSpeed() {
        return e_speed;
    }
    /** 
     * get death
     * @param x
     */
    public static int getDeath() {
        return death;
    }
    /** 
     * increase death
     * @param x
     */
    public static void incrDeath() {
        death++;
    }
    /**
     * 
     * @return scene of HomeScene
     */
    public static Scene getScene() {
        return Home.scene;
    }
    /**
     * set HomeStage
     */
    public static void setStage(Stage stage) {
        Home.stage = stage;

    }
    /**
     *  scene mit default werten
     */
    public static void defaultwerte() {
        hboxlbl2.setVisible(false);
        hbox_btn_lvl.setVisible(false);
        hbox_btn_gl.setVisible(false);
        speed= 0;
        e_speed = 0;
        death = 0;
    }
}
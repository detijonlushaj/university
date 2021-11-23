package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * final screen with death counter
 * @author lushaj
 *
 */
public class FinalScreen {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Timeline tl;
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]); 
    private static HBox hbox_lbl= new HBox();
    private static HBox hbox_menu= new HBox();
    private static Label lbl_deaths = new Label();
    private static Button btn_Home = new Button();
    private static ImageView iv_Player;
    private final static int s_posX = 385;
    private final static int s_posY = 295;
    private static boolean goUp, goDown, goRight, goLeft,running;
    private static boolean checkcheck;


    /**
     * Set the Layout for the final Screen
     */
    public static void setLayout() {
        //create a Gameloop 
        //free form animation defined by KeyFrames and their duration 
        tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run()));
        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);

        //Backgroung for Home
        Image Background = new Image("/lushaj_res/home_bg.gif");
        ImageView home_bg = new ImageView(Background);
        home_bg.setFitHeight(500);
        home_bg.setFitWidth(800);
        home_bg.setX(0.0);
        home_bg.setY(0.0);
        root.getChildren().addAll(home_bg);
        Font font = Font.font("Courier New", FontWeight.BOLD, 25);  //FRONT 4LEVEL

        //set labels and buttons

        lbl_deaths.setFont(font);
        lbl_deaths.setTextFill(Color.web("#FFFFFF"));

        //degree of hardness    
        hbox_lbl.getChildren().addAll(lbl_deaths);
        hbox_lbl.setPadding(new Insets(0, 0, 0, 0));
        hbox_lbl.setSpacing(30);
        //button go back   
        btn_Home.setText("GO BACK");
        btn_Home.setFont(font);
        btn_Home.setPrefSize(220, 30);
        btn_Home.setStyle( "-fx-background-color: #006d00; "
                + " -fx-base: White");
        //hbox  
        hbox_menu.getChildren().addAll(btn_Home);
        hbox_menu.setPadding(new Insets(10, 0, 0, 400-(110)));
        hbox_menu.setSpacing(30);

        //create player
        Image i_Player = new Image("/lushaj_res/morpheus.png");
        iv_Player = new ImageView(i_Player);
        iv_Player.setFitHeight(30);
        iv_Player.setFitWidth(30);

        //root
        VBox vboxeif = new VBox(); 
        vboxeif.getChildren().addAll(hbox_lbl,hbox_menu);
        root.setCenter(vboxeif);

        root.getChildren().addAll(iv_Player);

    }

    /**
     * set up the Events in LVL1
     */
    public static void setEvents() {
        btn_Home.setOnMouseEntered(e -> btn_Home.setText("-GO BACK-"));
        btn_Home.setOnMouseExited(e -> btn_Home.setText("GO BACK"));

        //WASD Controll true till releasd key
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @SuppressWarnings("incomplete-switch")
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                case UP:    goUp    = true; break;
                case DOWN:  goDown  = true; break;
                case LEFT:  goLeft  = true; break;
                case RIGHT: goRight = true; break;
                case W:     goUp    = true; break;
                case S:     goDown  = true; break;
                case A:     goLeft  = true; break;
                case D:     goRight = true; break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @SuppressWarnings("incomplete-switch")
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                case UP:    goUp    = false; break;
                case DOWN:  goDown  = false; break;
                case LEFT:  goLeft  = false; break;
                case RIGHT: goRight = false; break;
                case W:     goUp    = false; break;
                case S:     goDown  = false; break;
                case A:     goLeft  = false; break;
                case D:     goRight = false; break;
                }
            }
        });
        btn_Home.setOnAction(e -> {
            Sounds.reset_check();
            Sounds.check();
            stopGame();
            Home.setStage(stage);
            //Home.setLayout();
            //Home.setEvents();
            Home.defaultwerte();
            stage.setScene(Home.getScene());
        });

    }
    /**
     * gameloop
     * @param gc
     */
    public static void run() {
        //player x and y movement
        int dx = 0;
        int dy = 0;

        //WASD move the Player
        if (goUp)       dy -= 1;
        if (goDown)     dy += 1;
        if (goRight)    dx += 1;
        if (goLeft)     dx -= 1;
        if (running) { dx *= 3; dy *= 3; }

        //Move the Player 
        Move.moveX(iv_Player, dx);
        if (iv_Player.getX() < 0 || iv_Player.getX() > Main.getSize()[0]) {
            Move.moveX(iv_Player, -dx);
        }
        Move.moveY(iv_Player, dy);
        if (iv_Player.getY() < 0 || iv_Player.getY() > Main.getSize()[1]) {
            Move.moveY(iv_Player, -dy);
        }
    }
    /**
     * 
     * @return if you already set the Layout
     */
    public static boolean getCheck() {
        return checkcheck;
    }
    /**
     * 
     * set the Checkboolean false
     */
    public static void setCheck() {
        if(!checkcheck) {
            checkcheck = true;
        }
    }
    /**
     *  scene mit default werten
     */
    public static void defaultwerte() {
        lbl_deaths.setText("Deaths: " + Home.getDeath()  + 
                "\n\n\n\n\n\n                    - GOOD GAME -");
        setPalyer();
    }
    /**
     *  set the Player to default Position
     */
    public static void setPalyer() {
        iv_Player.setX(s_posX);
        iv_Player.setY(s_posY);       
    }

    /**
     * 
     * @return scene of LVL3
     */
    public static Scene getScene() {
        return FinalScreen.scene;
    }
    /**
     * to access access in this class
     * @param stage
     */
    public static void setStage(Stage stage) {
        FinalScreen.stage = stage;
    }
    /**
     *  start the gameloop
     */
    public static void startGame() {
        defaultwerte();
        tl.playFromStart();
    }
    /**
     *  end the gameloop
     */
    public static void stopGame() {
        tl.stop();
    }


}

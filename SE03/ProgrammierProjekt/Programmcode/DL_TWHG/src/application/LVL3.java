package application;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * third Level of TWHG
 * @author lushaj
 *
 */
public class LVL3 {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Timeline tl;
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static HBox hbox_menu= new HBox();
    private static Button btn_return;
    private static Button btn_nextlvl;
    private static Label lbl_deaths = new Label();
    private static ArrayList<Rectangle> walls;   
    private static ImageView gegner1,gegner2,gegner3,gegner4,gegner5,gegner6;
    private static ImageView iv_Player;
    private static ImageView iv_Coin_r1,iv_Coin_r2,iv_Coin_r3;
    private final static int timedivider = 160;
    private final static int s_posX = 200;
    private final static int s_posY = 200;
    //Verschiebung in die Mite
    private final static int dx =190;
    private final static int dy =160;
    private static int timer;
    private static int timestop;
    private static boolean b_Coin_r1,b_Coin_r2,b_Coin_r3;
    private static Rectangle end_pos;
    private static boolean goUp, goDown, goRight, goLeft;
    private static double speed;
    private static double e_speed;
    private static boolean checkcheck;

    /**
     * Set the Layout for LVL3
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
        //green game Area
        Rectangle balken = new Rectangle(0 ,0 , 800, 20);
        balken.setFill(Color.web("#ffffff"));
        //create a return Button
        btn_return = new Button();
        btn_return.setText("return");
        btn_return.setFont(Font.font("Courier New", FontWeight.BOLD, 10));
        //create a return Button
        btn_nextlvl = new Button();
        btn_nextlvl.setText("next Level");
        btn_nextlvl.setFont(Font.font("Courier New", FontWeight.BOLD, 10));
        //create death Label
        lbl_deaths.setText("Deaths: " + Home.getDeath());
        lbl_deaths.setFont(Font.font("Courier New", FontWeight.BOLD, 10));     
        lbl_deaths.setTextFill(Color.web("#ffffff"));
        //hbox menu
        hbox_menu.getChildren().addAll(btn_return,btn_nextlvl);
        hbox_menu.setSpacing(700);

        //game Area
        Rectangle start_pos = new Rectangle(0 + dx ,30 + dy, 120, 120);
        start_pos.setFill(Color.web("#778877"));
        end_pos = new Rectangle(360 + dx, 30 + dy, 60, 120);
        end_pos.setFill(Color.web("#778877"));
        Rectangle game_area1 = new Rectangle(60 + dx, 30 + dy, 300, 115);
        game_area1.setFill(Color.web("#ffffff"));
        Rectangle game_area2 = new Rectangle(120 + dx, 00 + dy, 180, 180);
        game_area2.setFill(Color.web("#ffffff"));
        root.getChildren().addAll(balken,start_pos,end_pos, game_area1,game_area2);

        //set walls
        walls = new ArrayList<Rectangle>();
        walls.add(new Rectangle(-5+dx, 25+dy, 125, 5));
        walls.add(new Rectangle(115+dx, -5+dy, 5, 30));
        walls.add(new Rectangle(120+dx, -5+dy, 185, 5));
        walls.add(new Rectangle(300+dx, 0+dy, 5, 30));
        walls.add(new Rectangle(305+dx, 25+dy, 120, 5));
        walls.add(new Rectangle(-5+dx, 145+dy, 125, 5));
        walls.add(new Rectangle(115+dx, 150+dy, 5, 35));
        walls.add(new Rectangle(120+dx, 180+dy, 185, 5));
        walls.add(new Rectangle(300+dx, 150+dy, 5, 30));
        walls.add(new Rectangle(300+dx, 145+dy, 125, 5));
        walls.add(new Rectangle(-5+dx, 30+dy, 5, 120));
        walls.add(new Rectangle(420+dx, 30+dy, 5, 120));
        //graphitblack colot for the walls
        for(Rectangle o : walls) {
            o.setFill(Color.web("#1c1c1c"));
        }
        root.getChildren().addAll(walls);

        //create Enemys
        Image i_Enemy = new Image("/lushaj_res/smith.png");
        gegner1 = new ImageView(i_Enemy);
        gegner1.setFitHeight(20);
        gegner1.setFitWidth(20);
        gegner2 = new ImageView(i_Enemy);
        gegner2.setFitHeight(20);
        gegner2.setFitWidth(20);
        gegner3 = new ImageView(i_Enemy);
        gegner3.setFitHeight(20);
        gegner3.setFitWidth(20);
        gegner4 = new ImageView(i_Enemy);
        gegner4.setFitHeight(20);
        gegner4.setFitWidth(20);
        gegner5 = new ImageView(i_Enemy);
        gegner5.setFitHeight(20);
        gegner5.setFitWidth(20);
        gegner6 = new ImageView(i_Enemy);
        gegner6.setFitHeight(20);
        gegner6.setFitWidth(20);
        root.getChildren().addAll(gegner1,gegner2,gegner3,gegner4,gegner5,gegner6);

        //create player
        Image i_Player = new Image("/lushaj_res/morpheus.png");
        iv_Player = new ImageView(i_Player);
        iv_Player.setFitHeight(20);
        iv_Player.setFitWidth(20);
        root.getChildren().addAll(iv_Player);

        //create coins to collect
        Image i_coin_red = new Image("/lushaj_res/red_p.png");
        iv_Coin_r1 = new ImageView(i_coin_red);
        iv_Coin_r1.setFitHeight(20);
        iv_Coin_r1.setFitWidth(10);
        iv_Coin_r2 = new ImageView(i_coin_red);
        iv_Coin_r2.setFitHeight(20);
        iv_Coin_r2.setFitWidth(10);
        iv_Coin_r3 = new ImageView(i_coin_red);
        iv_Coin_r3.setFitHeight(20);
        iv_Coin_r3.setFitWidth(10);
        root.getChildren().addAll(iv_Coin_r1,iv_Coin_r2,iv_Coin_r3);

        //set all Objects to default pos
        defaultwerte();
        //start the loop
        tl.play();
        
        //root
        VBox vboxeif = new VBox(); 
        vboxeif.getChildren().addAll(hbox_menu,lbl_deaths);
        root.setCenter(vboxeif);
        
    }
    /**
     * set up the Events in LVL3
     */
    public static void setEvents() {
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
        //Button Event
        btn_nextlvl.setOnAction(e -> {    
            Sounds.reset_check();
            Sounds.check();
            stopGame();
            if(!FinalScreen.getCheck()) {
                FinalScreen.setLayout();
                FinalScreen.setEvents();
            } 
            FinalScreen.setStage(stage);
            FinalScreen.startGame();
            stage.setScene(FinalScreen.getScene());
            FinalScreen.setCheck();
        });
        //Button Event <- return
        btn_return.setOnAction(e -> {
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
        checkCollisionEnemy();

        //Enemy movement
        timer++;
        if (timer >= timestop){
            timer = 0;
            e_speed = -e_speed;
        }
        Move.moveY(gegner1, e_speed);
        Move.moveY(gegner2, e_speed);
        Move.moveY(gegner3, -e_speed);
        Move.moveY(gegner4, -e_speed);
        Move.moveY(gegner5, e_speed);
        Move.moveY(gegner6, e_speed);

        //player x and y movement
        double dx = 0;
        double dy = 0;

        //WASD move the Player
        if (goUp)       dy += speed;
        if (goDown)     dy -= speed;
        if (goRight)    dx -= speed;
        if (goLeft)     dx += speed;
        // move X
        Move.moveX(iv_Player, dx);
        //Player interact with a wall in X
        for (Rectangle o : walls) {
            if(iv_Player.getBoundsInParent().intersects(o.getBoundsInParent())){
                Move.moveX(iv_Player, -dx);
            }
        }
        // move Y  
        Move.moveY(iv_Player, dy);
        //Player interact with a wall in Y 
        for (Rectangle o : walls) {
            if(iv_Player.getBoundsInParent().intersects(o.getBoundsInParent())){
                Move.moveY(iv_Player, -dy);
            }
        }
        
        checkCoinsCollected();
        check_goal();

    }

    /**
     * Checks if the Player touches the Enemy and respawn the Player and rise the death count
     */
    public static void checkCollisionEnemy() {
        if(iv_Player.getBoundsInParent().intersects(gegner1.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner2.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner3.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner4.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner5.getBoundsInParent())|| 
                iv_Player.getBoundsInParent().intersects(gegner6.getBoundsInParent())) {
            setPalyer();
            Sounds.reset_e_Sounds();
            Sounds.enemyhit();
            setCoins();
            setButton();
            Home.incrDeath();
            lbl_deaths.setText("Deaths: " + Home.getDeath());
        }
    }
    /**
     * Checks if the Player collected the coins
     */
    public static void checkCoinsCollected() {
        if(iv_Player.getBoundsInParent().intersects(iv_Coin_r1.getBoundsInParent())){
            if(b_Coin_r1 == false ) {
                Sounds.reset_coin();
                Sounds.coin();
            }
            b_Coin_r1 = true;
            iv_Coin_r1.setVisible(false);
            
        }
        if(iv_Player.getBoundsInParent().intersects(iv_Coin_r2.getBoundsInParent())){
            if(b_Coin_r2 == false ) {
                Sounds.reset_coin();
                Sounds.coin();
            }
            b_Coin_r2 = true;
            iv_Coin_r2.setVisible(false);
        }
        if(iv_Player.getBoundsInParent().intersects(iv_Coin_r3.getBoundsInParent())){
            if(b_Coin_r3 == false ) {
                Sounds.reset_coin();
                Sounds.coin();
            }
            b_Coin_r3 = true;
            iv_Coin_r3.setVisible(false);
        }
    }
    /**
     * checks if the player is in the goal
     */
    public static void check_goal() {
        if(iv_Player.getBoundsInParent().intersects(end_pos.getBoundsInParent())
                && b_Coin_r1 == true && b_Coin_r2 == true && b_Coin_r3 == true){
            btn_nextlvl.setVisible(true);
            Sounds.check();
        } 
        if(!iv_Player.getBoundsInParent().intersects(end_pos.getBoundsInParent())){
            Sounds.reset_check();
        } 
    }
    /**
     *  set the Timedivider for the Enemy loop
     */
    public static void setTimedivider() {
        //Time stop for the loop
        timer = 0;
        timestop = (int) (timedivider/e_speed);
    }
    /**
     *  set all Enemys to default Position
     */
    public static void setEnemys(int dx, int dy) {
        gegner1.setX(125+dx);
        gegner1.setY(00+dy);
        gegner2.setX(155+dx);
        gegner2.setY(00+dy);
        gegner3.setX(185+dx);
        gegner3.setY(160+dy);
        gegner4.setX(215+dx);
        gegner4.setY(160+dy);
        gegner5.setX(245+dx);
        gegner5.setY(00+dy);
        gegner6.setX(275+dx);
        gegner6.setY(00+dy);    
    }
    /**
     *  set the Player to default Position
     */
    public static void setPalyer() {
        iv_Player.setX(s_posX);
        iv_Player.setY(s_posY);       
    }
    /**
     *  set the Coins to default layout
     */
    public static void setCoins() {
        iv_Coin_r1.setX(145+dx);
        iv_Coin_r1.setY(40+dy);
        iv_Coin_r2.setX(205+dx);
        iv_Coin_r2.setY(120+dy);
        iv_Coin_r3.setX(265+dx);
        iv_Coin_r3.setY(40+dy);
        iv_Coin_r1.setVisible(true);
        iv_Coin_r2.setVisible(true);
        iv_Coin_r3.setVisible(true);
        b_Coin_r1 = false;
        b_Coin_r2 = false;
        b_Coin_r3 = false;
    }
    /**
     *  set the button to default layout
     */
    public static void setButton() {
        btn_nextlvl.setVisible(false);
    }
    /**
     * define speed
     * @param x
     */
    public static void setSpeed() {
        speed = Home.getSpeed();
    }
    /**
     * define enemy speed
     * @param x
     */
    public static void seteSpeed() {
        e_speed = Home.geteSpeed();
    }
    /**
     * 
     * @return scene of LVL3
     */
    public static Scene getScene() {
        return LVL3.scene;
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
     * to access access in this class
     * @param stage
     */
    public static void setStage(Stage stage) {
        LVL3.stage = stage;
    }
    /**
     *  scene mit default werten
     */
    public static void defaultwerte() {
        setSpeed();
        seteSpeed();
        setTimedivider();
        setButton();
        setEnemys(dx, dy);
        setPalyer();
        setCoins();
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

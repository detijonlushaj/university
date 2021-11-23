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
 * fist Level of TWHG
 * @author lushaj
 *
 */
public class LVL1 {
    private static Stage stage;
    private static BorderPane root = new BorderPane();
    private static Timeline tl;
    private static Scene scene = new Scene(root, Main.getSize()[0], Main.getSize()[1]);
    private static HBox hbox_menu= new HBox();
    private static Button btn_return;
    private static Button btn_nextlvl;
    private static Label lbl_deaths = new Label();
    private static ArrayList<Rectangle> walls;   
    private static ImageView gegner1,gegner2,gegner3,gegner4;
    private static ImageView iv_Player;
    private final static int timedivider = 280;
    private final static int s_posX = 165;
    private final static int s_posY = 200;
    //Verschiebung in die Mite
    private final static int dx =125;
    private final static int dy =160;
    private static int timestop;
    private static int timer;
    private static Rectangle end_pos;
    private static boolean goUp, goDown, goRight, goLeft;
    private static double speed;
    private static double e_speed;
    private static boolean checkcheck;

    /**
     * Set the Layout for LVL1
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
        Rectangle start_pos = new Rectangle(0 + dx ,0 + dy, 95, 190);
        start_pos.setFill(Color.web("#ffffff"));
        end_pos = new Rectangle(460+ dx, 10 + dy, 90, 175);
        end_pos.setFill(Color.web("#ffffff"));
        Rectangle game_area1 = new Rectangle(390 + dx, 10 + dy, 70, 30);
        game_area1.setFill(Color.web("#778877"));
        Rectangle game_area2 = new Rectangle(120+ dx, 40+ dy, 310, 26);
        game_area2.setFill(Color.web("#778877"));
        Rectangle game_area3 = new Rectangle(120+ dx, 66+ dy, 310, 29);
        game_area3.setFill(Color.web("#778877"));
        Rectangle game_area4 = new Rectangle(120+ dx, 95+ dy, 310, 30);
        game_area4.setFill(Color.web("#778877"));
        Rectangle game_area5 = new Rectangle(120+ dx, 125+ dy, 310, 30);
        game_area5.setFill(Color.web("#778877"));
        Rectangle game_area6 = new Rectangle(90+ dx, 155+ dy, 70, 30);
        game_area6.setFill(Color.web("#778877"));
        root.getChildren().addAll(balken,start_pos,end_pos, game_area1,game_area2,game_area3, game_area4, game_area5, game_area6);

        //set walls
        walls = new ArrayList<Rectangle>();
        walls.add(new Rectangle(0+dx, 0+dy, 5, 190));
        walls.add(new Rectangle(5+dx, 185+dy, 150, 5));
        walls.add(new Rectangle(0+dx, dy, 90, 5));
        walls.add(new Rectangle(90+dx, dy, 5, 155));
        walls.add(new Rectangle(95+dx, 150+dy, 30, 5));
        walls.add(new Rectangle(155+dx, 150+dy, 5, 40));
        walls.add(new Rectangle(120+dx, 35+dy, 5, 120));
        walls.add(new Rectangle(120+dx, 35+dy, 270, 5));
        walls.add(new Rectangle(155+dx, 150+dy, 270, 5));
        walls.add(new Rectangle(390+dx, 5+dy, 155, 5));
        walls.add(new Rectangle(425+dx, 35+dy, 5, 120));
        walls.add(new Rectangle(390+dx, 5+dy, 5, 35));
        walls.add(new Rectangle(545+dx, 5+dy, 5, 185));
        walls.add(new Rectangle(455+dx, 185+dy, 95, 5));
        walls.add(new Rectangle(455+dx, 35+dy, 5, 150));
        walls.add(new Rectangle(425+dx, 35+dy, 30, 5));

        //graphitblack color for the walls
        for(Rectangle o : walls) {
            o.setFill(Color.web("#1c1c1c"));
        }
        root.getChildren().addAll(walls);

        //create and set Enemys 
        Image i_Enemy = new Image("/lushaj_res/smith.png");
        gegner1 = new ImageView(i_Enemy);
        gegner1.setFitHeight(18);
        gegner1.setFitWidth(18);
        gegner2 = new ImageView(i_Enemy);
        gegner2.setFitHeight(18);
        gegner2.setFitWidth(18);
        gegner3 = new ImageView(i_Enemy);
        gegner3.setFitHeight(18);
        gegner3.setFitWidth(18);
        gegner4 = new ImageView(i_Enemy);
        gegner4.setFitHeight(18);
        gegner4.setFitWidth(18);
        root.getChildren().addAll(gegner1, gegner2, gegner3, gegner4);

        //create players
        Image i_Player = new Image("/lushaj_res/morpheus.png");
        iv_Player = new ImageView(i_Player);
        iv_Player.setFitHeight(15);
        iv_Player.setFitWidth(15);
        root.getChildren().addAll(iv_Player);

        
        //root
        VBox vboxeif = new VBox(); 
        vboxeif.getChildren().addAll(hbox_menu,lbl_deaths);
        root.setCenter(vboxeif);
    }

    /**
     * set up the Events in LVL1
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
        //Button Event -> next LVL
        btn_nextlvl.setOnAction(e -> {
            Sounds.reset_check();
            Sounds.check();
            stopGame();
            if(!LVL2.getCheck()) {
                LVL2.setLayout();
                LVL2.setEvents();
            } 
            LVL2.setStage(stage);
            LVL2.startGame();
            stage.setScene(LVL2.getScene());
            LVL2.setCheck();
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
        Move.moveX(gegner1, e_speed);
        Move.moveX(gegner2, -e_speed);
        Move.moveX(gegner3, e_speed);
        Move.moveX(gegner4, -e_speed);

        //player x and y movement
        double dx = 0;
        double dy = 0;

        //WASD move the Player
        if (goUp)       dy -= speed;
        if (goDown)     dy += speed;
        if (goRight)    dx += speed;
        if (goLeft)     dx -= speed;

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

        check_goal();
    }
    /**
     * Checks if the Player touches the Enemy and respawn the Player and rise the death count
     */
    public static void checkCollisionEnemy() {
        if(iv_Player.getBoundsInParent().intersects(gegner1.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner2.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner3.getBoundsInParent()) || 
                iv_Player.getBoundsInParent().intersects(gegner4.getBoundsInParent()) ) {
            setPalyer();
            Sounds.reset_e_Sounds();
            Sounds.enemyhit();
            setButton();
            Home.incrDeath();
            lbl_deaths.setText("Deaths: " + Home.getDeath());
        }
    }
    /**
     * checks if the player is in the goal
     */
    public static void check_goal() {
        if(iv_Player.getBoundsInParent().intersects(end_pos.getBoundsInParent())){
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
        gegner1.setY(48+dy);
        gegner2.setX(405+dx);
        gegner2.setY(73+dy);
        gegner3.setX(125+dx);
        gegner3.setY(98+dy);
        gegner4.setX(405+dx);
        gegner4.setY(123+dy);        
    }    
    /**
     *  set the Player to default Position
     */
    public static void setPalyer() {
        iv_Player.setX(s_posX);
        iv_Player.setY(s_posY);       
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
        e_speed = Home.geteSpeed()  * 1.5;
    }
    /**
     * 
     * @return scene of LVL1
     */
    public static Scene getScene() {
        return LVL1.scene;
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
        LVL1.stage = stage;
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

package view;

import java.util.ArrayList;
import java.util.Random;

import Sounds.Sound;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.InfoLabel;
import model.SpaceInvaderButton;
import model.SpaceInvadersSubScene;

public class GameViewManager {
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;

    private static final int WIDTH = 900;
    private static final int HIGHT = 900;

    // Hier ist alles was mit dem Spieler zutun hat
    private ImageView PLAYER; // MAIN PLAYER
    private int PLAYERSpeed;
    private static final int Player_RADIUS = 20;
    private int angle;// WHEN D PRESSED ANGEL IS TO THE LEFT OR WHEN
    private static final String PLAYER_PATH = "ProjecktPics/gameElements/Player.png";

    // Hier ist alles was mit den Meteoren zutun hat
    private ImageView[] bigMeteors;
    private ImageView[] smallMeteors;
    private int meteorsNumber;
    private int MeteorVelocity[];
    private int meteorRotationVelocity[];
    private static final int smallMeteors_RADIUS = 15;
    private static final int bigMeteors_RADIUS = 25;
    private static final String METEOR1_PATH = "ProjecktPics/gameElements/meteor1.png";
    private static final String METEOR2_PATH = "ProjecktPics/gameElements/meteor2.png";

    // Hier ist alles was mit den Sternen zutun hat
    private ImageView stars[];
    private int starsNumber;
    private int starsVelocity[];
    private static final int STAR_RADIUS = 10;
    private static final String STAR_PATH = "ProjecktPics/gameElements/star_small.png";

    // Hier ist alles was mit den Shots zutun hat
    private ArrayList<ImageView> shots;
    private int shootedShots;
    private int ableShots;
    private InfoLabel shootedShotsLabel;
    private static final String shot_PATH = "ProjecktPics/gameElements/shot2.png";

    // Hier ist alles was mit den Feinden zutun hat
    private ImageView[] enemies;
    private int enemiesNumber;
    private int enemiesAVelocity[];
    private static final int enemies_RADIUS = 20;
    private static final String ENEMIE1_PATH = "ProjecktPics/gameElements/enemy_B.png";
    private static final String ENEMIE2_PATH = "ProjecktPics/gameElements/enemy_C.png";
    private static final String ENEMIE3_PATH = "ProjecktPics/gameElements/enemy_D.png";

    private InfoLabel LifesLabel; // LABEL FOR THE LivesLabel IN THE GAME POS: TOP RIGHT
    private ImageView[] playerLifes;
    private int lifesNumber = 7;
    private static final String heart_PATH = "ProjecktPics/gameElements/heart.png";

    private InfoLabel scoreLabel; // LABEL FOR THE SCORE IN THE GAME POS: TOP RIGHT
    private int score = 0;
    private int scoreToAchive;
    private String scoreInBinary;

    private InfoLabel shownLevelLabel; // LABEL FOR THE LEVEL IN THE GAME POS: TOP LEFT
    private int whichLevelIschoosenLevel; // z.B : LEVEL 1 || LEVEL 2 || ....

    // Scene wenn man ein Level gewinnt
    private SpaceInvadersSubScene levelUpScene;
    private InfoLabel scoreLabelInNxetScene;
    private InfoLabel klicksLabelInNxetScene;
    private SpaceInvaderButton nextLevelStagebutton;

    // Scene wenn man ein Level verliert
    private SpaceInvadersSubScene gameOverScene;
    private InfoLabel gameOverLabel;
    private InfoLabel gameOverScoreLabel;
    private InfoLabel gameOverklicksLabel;
    private SpaceInvaderButton gameOverMenubutton;
    // Timer damit ein GameLoop möglich ist und Random weil muss :D
    private AnimationTimer gameTimer;
    private Random randomPositionGenerator;
    // Diese Attribute sind wichtig für die movePlayer() Methode
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private boolean isUpKeyPressed;
    private boolean isDownKeyPressed;
    private boolean isSpaceKeyPressed;

    private boolean isMouseKlicked;
    private int KlicksCounter = 0;
    private static final String Background_PATH = "ProjecktPics/ViewElements/sterne5.gif";
    private Sound sounds;

    /* Konstruktor */
    public GameViewManager(int level) {
        initializeGameViewManager(level);
    }

    /*
     * DIESE METHODE IST ALLES WAS MAN VORINITIALIZIEREN MUSS WIE Z.B SCENE UND
     * STAGE UND LEVE DAMIT WEITERE METHODEN FUNKTIONIERTEN
     */
    public void initializeGameViewManager(int level) {
        this.whichLevelIschoosenLevel = level;
        this.sounds = new Sound();
        this.sounds.loadSounds();
        this.gamePane = new AnchorPane();
        this.gameScene = new Scene(gamePane, WIDTH, HIGHT);
        this.gameStage = new Stage();
        this.gameStage.setScene(gameScene);
        this.gameStage.setTitle("Space Runner");

        createView();
        initializeVelocities(whichLevelIschoosenLevel);
        createKeyListener();
//        mainStage.setResizable(false);
    }

    /* DIESE METHODE MACHT ALLES WAS MAN AUF DIE STAGE SIEHT */
    public void createView() {
        setLevelsettings();
        creatBackground();
        createShownLevelLabel();
        createShootedShotsLabel();
        createScoreLabel();
        createLivesLabel();
        createLives();
    }

    /*
     * DIESE METHODE BESTIMMT WELCHE SETTEINGS FÜR WELCHE LEVEL AUSGEWÄHLT WERDEN
     * SOLL WIE Z.B WIE SCHNELL DIE FEINDE SICH BEWEGEN
     */
    public void setLevelsettings() {
        randomPositionGenerator = new Random();
        shots = new ArrayList<ImageView>();
        if (whichLevelIschoosenLevel == 1) {
            scoreToAchive = 500;
            score = 0;
            PLAYERSpeed = 14;
            meteorsNumber = 3; // 3 KLEINE METEOREN UND 3 GROßE METHEOREN
            enemiesNumber = 3;
            starsNumber = 1000;
            shootedShots = 0;
            ableShots = 4000;
        } else if (whichLevelIschoosenLevel == 2) {
            scoreToAchive = 1000;
            score = 0;
            PLAYERSpeed = 13;
            meteorsNumber = 4;
            enemiesNumber = 4;
            starsNumber = 800;
            shootedShots = 0;
            ableShots = 3000;
        } else if (whichLevelIschoosenLevel == 3) {
            scoreToAchive = 2000;
            score = 0;
            PLAYERSpeed = 12;
            meteorsNumber = 7;
            enemiesNumber = 7;
            starsNumber = 500;
            shootedShots = 0;
            ableShots = 2000;
        } else if (whichLevelIschoosenLevel == 4) {
            scoreToAchive = 3000;
            score = 0;
            PLAYERSpeed = 11;
            meteorsNumber = 7;
            enemiesNumber = 9;
            starsNumber = 400;
            shootedShots = 0;
            ableShots = 1000;
        }
    }

    /* DAMIT JEDES OBJECKT SEINE EIGENE GESCHWINDDIGKEIT BEKOMMT */
    public void initializeVelocities(int level) {
        MeteorVelocity = new int[meteorsNumber];
        meteorRotationVelocity = new int[meteorsNumber];
        starsVelocity = new int[starsNumber];
        enemiesAVelocity = new int[enemiesNumber];
        int levelFunction = (int) Math.pow(level, 2);
        for (int n = 0; n < MeteorVelocity.length; n++) {
            MeteorVelocity[n] = randomPositionGenerator.nextInt(levelFunction + 5) + 2;
        }
        for (int n = 0; n < meteorRotationVelocity.length; n++) {
            meteorRotationVelocity[n] = randomPositionGenerator.nextInt(levelFunction + 5) + 2;

        }
        for (int n = 0; n < starsVelocity.length; n++) {
            starsVelocity[n] = randomPositionGenerator.nextInt(levelFunction + 5) + 2;

        }
        for (int n = 0; n < enemiesAVelocity.length; n++) {
            enemiesAVelocity[n] = randomPositionGenerator.nextInt(levelFunction + 5) + 2;
        }
    }

    /*
     * BOOLISCHE WERTE WERDEN AUF TRUE GESETZT WENN MAN DIE MOVING TASTEN PRESSED
     * ODER AUCH ANDERSRUM
     */
    public void createKeyListener() {
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.A) {
                    isLeftKeyPressed = true;
                } else if (event.getCode() == KeyCode.D) {
                    isRightKeyPressed = true;
                } else if (event.getCode() == KeyCode.W) {
                    isUpKeyPressed = true;
                } else if (event.getCode() == KeyCode.S) {
                    isDownKeyPressed = true;
                } else if (event.getCode() == KeyCode.SPACE) {
                    isSpaceKeyPressed = true;
                }
                KlicksCounter++;
            }
        });
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.A) {
                    isLeftKeyPressed = false;
                } else if (event.getCode() == KeyCode.D) {
                    isRightKeyPressed = false;
                } else if (event.getCode() == KeyCode.W) {
                    isUpKeyPressed = false;
                } else if (event.getCode() == KeyCode.S) {
                    isDownKeyPressed = false;
                } else if (event.getCode() == KeyCode.SPACE) {
                    isSpaceKeyPressed = false;
                }
            }
        });
        gameScene.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                if (event.getButton().equals(MouseButton.PRIMARY)) {
//                    sounds.shotSoundStop();
                    sounds.shotSoundStart();
                    KlicksCounter++;
                    creatShot();
                    isMouseKlicked = true;
                }
            }

        });
        gameScene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sounds.shotSoundStop();
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    isMouseKlicked = false;
                }
            }
        });
    }

    /**
     * DIESE METHODE RUFT DIE METHODEN INNERHALN MEIN ANIMATIONTIMER EINMAL PER /
     * FRAME
     */
    public void creatGameLoop() {
        gameTimer = new AnimationTimer() {
            long prevTime = 0;

            @Override
            public void handle(long now) {
                prevTime = now - prevTime;
//                System.out.println(prevTime / Math.pow(10, -9));
                moveGameElements();
                checkCollestion();
            }
//            public void setDuatration(int time) {
//                if (time * Math.pow(10, -9) > prevTime * Math.pow(10, -9)){}                             
//            }

        };
        gameTimer.start();
    }

    /*
     * DIESE METHODE WIRD VON DEM NÄCHSETEN GameViewManager AUFGERUFEN WEIL ICH IRGENDWIE  DIE menuStage
     * WEITER ÜBERTRAGEN KANN DAMIT ICH IN DEM HAUPTMENU ZURÜCK KEHREN KANN OHNE
     * EINEN NEUEN OBJEKT ZU KONSTRUIEREN, MAN SETZT DIE THIS MENU STAGE AUF DIE MENU
     * STAGE VON DEM GUI UND DANN DIE SHOW METHODE AUF DEM THIS gameStage
     */
    public void creatNewGame(Stage menuStage) {
        this.menuStage = menuStage;
        this.menuStage.hide();
        setLevelsettings();
        creatGameElements();
        creatGameLoop();
        gameStage.show();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////   
//VIEW LABELES, BUTTONS, ALLES WAS MIT DER VIEW ZUTUN HAT. 
    /*
     * DIESE METHODE ERSTELLT LevelInfoLabel(WAS MAN OBEN LINKS SIEHT WENN MAN EIN
     * LEVEL STARTET)
     */
    public void createShownLevelLabel() {
        shownLevelLabel = new InfoLabel(" Level: " + whichLevelIschoosenLevel);
        shownLevelLabel.setLayoutX(0);
        shownLevelLabel.setLayoutY(0);
        shownLevelLabel.setOpacity(0.4);
        shownLevelLabel.setAlignment(Pos.BASELINE_LEFT);
        gamePane.getChildren().add(shownLevelLabel);
    }

    /*
     * DIESE METHODE ERSTELLT ShootedShotsInfoLabel(WAS MAN OBEN LINKS SIEHT, WENN
     * MAN EIN LEVEL STARTET)
     */
    public void createShootedShotsLabel() {
        shootedShotsLabel = new InfoLabel(" Shots : " + (ableShots - shootedShots));
        if ((ableShots - shootedShots) == 0) {
            shootedShotsLabel.setText(" NO AMMO LEFT!");
        }
        shootedShotsLabel.setLayoutX(0);
        shootedShotsLabel.setLayoutY(60);
        shootedShotsLabel.setOpacity(0.4);
        shootedShotsLabel.setAlignment(Pos.BASELINE_LEFT);
        gamePane.getChildren().add(shootedShotsLabel);

    }

    /*
     * DIESE METHODE ERSTELLT ScoreInfoLabel(WAS MAN OBEN RECHTS SIEHT, WENN MAN EIN
     * LEVEL STARTET)
     */
    public void createScoreLabel() {
        scoreInBinary = Integer.toBinaryString(score);
        scoreLabel = new InfoLabel(" Score: " + scoreInBinary);
        scoreLabel.setLayoutX(520);
        scoreLabel.setLayoutY(0);
        scoreLabel.setOpacity(0.4);
        scoreLabel.setAlignment(Pos.BASELINE_LEFT);
        gamePane.getChildren().add(scoreLabel);
    }

    /*
     * DIESE METHODE ERSTELLT LivesInfoLabel(WAS MAN OBEN RECHTS SIEHT, WENN MAN EIN
     * LEVEL STARTET)
     */
    public void createLivesLabel() {
        LifesLabel = new InfoLabel(" Lives: ");
        LifesLabel.setLayoutX(520);
        LifesLabel.setLayoutY(60);
        LifesLabel.setOpacity(0.4);
        LifesLabel.setAlignment(Pos.BASELINE_LEFT);
        gamePane.getChildren().add(LifesLabel);
    }

    /*
     * DIESE METHODE ERSTELLT DIE Lives IN DEM LivesInfoLabel(WAS MAN OBEN RECHTS
     * SIEHT, WENN MAN EIN LEVEL STARTET)
     */
    public void createLives() {
        playerLifes = new ImageView[lifesNumber];
        for (int n = 0; n < lifesNumber; n++) {
            playerLifes[n] = new ImageView(heart_PATH);
            playerLifes[n].setFitHeight(60);
            playerLifes[n].setFitWidth(60);
            playerLifes[n].setLayoutX(840 - n * 30);
            playerLifes[n].setLayoutY(60);
            gamePane.getChildren().add(playerLifes[n]);
        }
    }

    /* WIRD BEI DER KOLLESION AUFGERUFEN */
    public void loseLife() {
        gamePane.getChildren().remove(playerLifes[lifesNumber]);
        if (lifesNumber <= 0) {
            creatGameOverSubScene();
        }
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //DAS SIND ALLE SUBSCENEN, LABELS UND BUTTONS NACHDEM MAN ETWEDER GEWINNT ODER VERLIERT 
    //PRINZIPIEL 2 SUBSCENEN DIE GLEICH SIND MIT EINEM UNTERSCHIED LEVEL UP SUBSCENE HAT EIN NEXT LEVEL BUTTON UND GAME OVER SUBSCENE NICHT :D 

    /* NICHT FERTIG IMPLEMENTIERT */
    public void creatNeededTimeLabel(SpaceInvadersSubScene scene, InfoLabel Label, int XLayout, int YLayout) {
        Label = new InfoLabel(" You pressed " + KlicksCounter + " times!");
        scene.getPane().getChildren().add(Label);
        Label.setLayoutX(XLayout);
        Label.setLayoutY(YLayout);
        Label.setAlignment(Pos.CENTER_LEFT);
    }

    /*
     * DISE LABEL KOMMT AUF DER LevelUpScene ODER GameOverSunScene UND ZEIGT SCORE
     */
    public void creatAfterLevelScoreLabel(SpaceInvadersSubScene scene, InfoLabel Label, int XLayout, int YLayout) {
        Label = new InfoLabel(" Score:   " + score + "(Dezimal)");
        scene.getPane().getChildren().add(Label);
        Label.setLayoutX(XLayout);
        Label.setLayoutY(YLayout);
        Label.setAlignment(Pos.CENTER_LEFT);
    }

    /*
     * DIESE SCENE IST DIE LEVEL UP SCENE UND SIE WIRD AUFGERUFEN WENN MAN EIN LEVEL
     * GEWEINNT
     */
    public void creatLevelUpScene() {
        levelUpScene = new SpaceInvadersSubScene(3);
        gamePane.getChildren().add(levelUpScene);
        creatNextLevelStagebutton();
        creatAfterLevelScoreLabel(levelUpScene, scoreLabelInNxetScene, 100, 165);
        creatAfterLevelSceneKliksLabel(levelUpScene, klicksLabelInNxetScene, 100, 250);
        creatMenuStagebutton(levelUpScene, nextLevelStagebutton, 360, 472);
    }

    /* DIESE BUTTON KOMMT AUF DER LevelUpScene UND ZEIGT SCORE */
    public void creatNextLevelStagebutton() {
        nextLevelStagebutton = new SpaceInvaderButton("Next Lvl");
        levelUpScene.getPane().getChildren().add(nextLevelStagebutton);
        nextLevelStagebutton.setLayoutX(50);
        nextLevelStagebutton.setLayoutY(82.5);
        nextLevelStagebutton.setPrefWidth(190);
        nextLevelStagebutton.setPrefHeight(45);
        nextLevelStagebutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (whichLevelIschoosenLevel == 5) {
                    whichLevelIschoosenLevel = 0;
                }
                GameViewManager nextLevel = new GameViewManager(whichLevelIschoosenLevel + 1);
                nextLevel.creatNewGame(menuStage);
                gameStage.close();
            }
        });
    }

    /* DIESE SCENE IST DER GAME OVER SCENE, KOMMT NACH DAS VERLIEREN */
    public void creatGameOverSubScene() {
        gameOverScene = new SpaceInvadersSubScene(3);
        gameTimer.stop();
        gamePane.getChildren().add(gameOverScene);
        creatGameOverLabel();
        creatAfterLevelScoreLabel(gameOverScene, gameOverScoreLabel, 100, 200);
        creatAfterLevelSceneKliksLabel(gameOverScene, gameOverklicksLabel, 100, 300);
        creatMenuStagebutton(gameOverScene, gameOverMenubutton, 360, 472);
    }

    /* DIESE LABEL IST DER LABEL WO GAME OVER STEHT */
    public void creatGameOverLabel() {
        gameOverLabel = new InfoLabel(" Game Over !");
        gameOverLabel.setLayoutX(100);
        gameOverLabel.setLayoutY(100);
        gameOverLabel.setAlignment(Pos.BASELINE_CENTER);
        gameOverScene.getPane().getChildren().add(gameOverLabel);

    }

    /* DIESE LABEL IST DER SCORE LABEL WO score STEHT */
    public void creatAfterLevelScoreLabel() {
        scoreLabelInNxetScene = new InfoLabel(" Score:   " + score + "(Dezimal)");
        levelUpScene.getPane().getChildren().add(scoreLabelInNxetScene);
        scoreLabelInNxetScene.setLayoutX(100);
        scoreLabelInNxetScene.setLayoutY(165);
        scoreLabelInNxetScene.setAlignment(Pos.CENTER_LEFT);
    }

    /* DIESE LABEL IST DER Klicks LABEL WO GAME OVER STEHT */
    public void creatAfterLevelSceneKliksLabel(SpaceInvadersSubScene scene, InfoLabel Label, int XLayout, int YLayout) {
        Label = new InfoLabel(" You pressed " + KlicksCounter + " times!");
        scene.getPane().getChildren().add(Label);
        Label.setLayoutX(XLayout);
        Label.setLayoutY(YLayout);
        Label.setAlignment(Pos.CENTER_LEFT);
    }

    /* BUTTON FÜR MENU STAGE ( KOMMT IN NEXTSUB SCENE UND IN GAMEOVER SCENE */
    public void creatMenuStagebutton(SpaceInvadersSubScene scene, SpaceInvaderButton button, int XLayout, int YLayout) {
        button = new SpaceInvaderButton("Menu");
        scene.getPane().getChildren().add(button);
        button.setLayoutX(XLayout);
        button.setLayoutY(YLayout);
        button.setPrefWidth(190);
        button.setPrefHeight(45);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameStage.close();
                menuStage.show();
            }
        });

    }

    /* BACKGROUND METHODE */
    public void creatBackground() {

        // HIER IST DIE PRO METHODE
        Image background = new Image(Background_PATH, WIDTH, HIGHT, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        gamePane.setBackground(new Background(backgroundImage));
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////
    /* DIESE METODE ERSTELLT DEN SPIELER UND SETTET DEN AUF ORIGINAL POSITION(400, 750) */
    public void createPlayer() {
        PLAYER = new ImageView(PLAYER_PATH);
        setStandartPLAYERPostion();
        gamePane.getChildren().add(PLAYER);
    }

    /* DISEE METHODE ERSTELLT EINEN SCHUSS WENN MAN AUF SEIN MOUSE KLICKT */
    public void creatShot() {
        if (!(shootedShots == ableShots)) {
            ImageView shot = new ImageView(shot_PATH);
            shot.setFitWidth(5);
            shot.setFitHeight(30);
            shot.setLayoutX(PLAYER.getLayoutX() + 15);
            shot.setLayoutY(PLAYER.getLayoutY() - 20);
            shots.add(shot);
            gamePane.getChildren().add(shot);
            shootedShots++;

            gamePane.getChildren().remove(shootedShotsLabel);
            createShootedShotsLabel();

        }

    }

    /*
     * STARS WERDEN ERSTELLT UND IN EINEM ARRAY GESPEICHERT UND GESTREUT MIT DER
     * setNewElementPostion METHODE
     * ALLE IF ÜBERPRÜFUNGEN BESTIMMEN DIE GRÖßE EINES STERNES IN ABHÄNIGKEIT MIT DER GESCHWINDIGKEIT
     * KLEINE STERNE FLIEGEN LANGSAMER UND GROßE STERNE FLIEGEN SCHNELLER :) 
     */
    public void creatStars() {
        stars = new ImageView[starsNumber];
        for (int i = 0; i < stars.length; i++) {
            if (starsVelocity[i] < 8) {
                stars[i] = new ImageView(STAR_PATH);
                stars[i].setFitHeight(10);
                stars[i].setFitWidth(10);
                setElementNewPostion(stars[i]);
                gamePane.getChildren().add(stars[i]);
            } else if (starsVelocity[i] < 10) {
                stars[i] = new ImageView(STAR_PATH);
                stars[i].setFitHeight(15);
                stars[i].setFitWidth(15);
                setElementNewPostion(stars[i]);
                gamePane.getChildren().add(stars[i]);

            } else if (starsVelocity[i] < 12) {
                stars[i] = new ImageView(STAR_PATH);
                stars[i].setFitHeight(20);
                stars[i].setFitWidth(20);
                setElementNewPostion(stars[i]);
                gamePane.getChildren().add(stars[i]);

            } else if (starsVelocity[i] < 14) {
                stars[i] = new ImageView(STAR_PATH);
                stars[i].setFitHeight(25);
                stars[i].setFitWidth(25);
                setElementNewPostion(stars[i]);
                gamePane.getChildren().add(stars[i]);

            } else if (starsVelocity[i] < 16) {
                stars[i] = new ImageView(STAR_PATH);
                stars[i].setFitHeight(30);
                stars[i].setFitWidth(30);
                setElementNewPostion(stars[i]);
                gamePane.getChildren().add(stars[i]);
            } else {
                stars[i] = new ImageView(STAR_PATH);
                stars[i].setFitHeight(45);
                stars[i].setFitWidth(45);
                setElementNewPostion(stars[i]);
                gamePane.getChildren().add(stars[i]);
            }
        }
    }

    /*
     * SmallMeteors WERDEN ERSTELLT UND IN EINEM ARRAY GESPEICHERT UND GESTREUT MIT
     * DER setNewElementPostion METHODE
     */
    public void creatSmallMeteors() {
        smallMeteors = new ImageView[meteorsNumber];
        for (int i = 0; i < smallMeteors.length; i++) {
            smallMeteors[i] = new ImageView(METEOR2_PATH);
            setElementNewPostion(smallMeteors[i]);
            gamePane.getChildren().add(smallMeteors[i]);
        }
    }

    /*
     * BigMeteors WERDEN ERSTELLT UND IN EINEM ARRAY GESPEICHERT UND GESTREUT MIT
     * DER setNewElementPostion METHODE
     */
    public void creatBigMeteors() {
        bigMeteors = new ImageView[meteorsNumber];
        for (int i = 0; i < bigMeteors.length; i++) {
            bigMeteors[i] = new ImageView(METEOR1_PATH);
            setElementNewPostion(bigMeteors[i]);
            gamePane.getChildren().add(bigMeteors[i]);

        }
    }

    /*
     * Enemies WERDEN ERSTELLT UND IN EINEM ARRAY GESPEICHERT UND GESTREUT MIT DER
     * setNewElementPostion METHODE
     */
    public void createsEnemies() {
        enemies = new ImageView[enemiesNumber];
        for (int n = 0; n < enemies.length; n++) {
            if (n % 3 == 0) {
                enemies[n] = new ImageView(ENEMIE1_PATH);
            } else if (n % 3 == 1) {
                enemies[n] = new ImageView(ENEMIE2_PATH);
            } else if (n % 3 == 2) {
                enemies[n] = new ImageView(ENEMIE3_PATH);
            }
            enemies[n].setRotate(180);
            setElementNewPostion(enemies[n]);
            gamePane.getChildren().add(enemies[n]);
        }
    }

    /* GEMEINSAME SCHNITTSCHTELLE DAMIT DER CODE NICHT SPAGETTI WIRD :D */
    public void creatGameElements() {
        createPlayer();
        // createShot wird in der Gameloop aufgerufen
        creatStars();
        creatBigMeteors();
        creatSmallMeteors();
        createsEnemies();
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////// 
    /*
     * DIESE METHODE ISE FÜR SPIELER BEWEGUNG UND ROTATION BEIM BEWEGEN
     * VERANTWORTLICH
     */
    public void movePlayer() {
        // if A is pressed and D is not pressed
        if (isLeftKeyPressed && !isRightKeyPressed) {
            if (angle > -10) {
                angle -= 3;
            }
            PLAYER.setRotate(angle);
            if (PLAYER.getLayoutX() > 0) {
                PLAYER.setLayoutX(PLAYER.getLayoutX() - PLAYERSpeed);
            }
        }
        // if D is pressed and A is not pressed
        if (isRightKeyPressed && !isLeftKeyPressed) {
            if (angle < 10) {
                angle += 3;
            }
            PLAYER.setRotate(angle);
            if (PLAYER.getLayoutX() < 836) {
                PLAYER.setLayoutX(PLAYER.getLayoutX() + PLAYERSpeed);
            }
        }
        // if A and D are pressed
        if (!isLeftKeyPressed && !isRightKeyPressed) {
            if (angle < 0) {
                angle += 3;
            } else if (angle > 0) {
                angle -= 3;
            }
            PLAYER.setRotate(angle);
        }
        // if A and D are not pressed
        if (isLeftKeyPressed && isRightKeyPressed) {
            if (angle < 0) {
                angle += 3;
            } else if (angle > 0) {
                angle -= 3;
            }
            PLAYER.setRotate(angle);
        }
        if (isUpKeyPressed && !isDownKeyPressed) {
            PLAYER.setLayoutY(PLAYER.getLayoutY() - PLAYERSpeed);
            if (PLAYER.getLayoutY() < 0) {
                PLAYER.setLayoutY(PLAYER.getLayoutY() + PLAYERSpeed);
            }
        }
        if (isDownKeyPressed && !isUpKeyPressed) {
            PLAYER.setLayoutY(PLAYER.getLayoutY() + PLAYERSpeed);
            if (PLAYER.getLayoutY() > 836) {
                PLAYER.setLayoutY(PLAYER.getLayoutY() - PLAYERSpeed);
            }
        }// TRY SPACE IN THE GAME :-)
        if (isSpaceKeyPressed) {
            creatShot();
        }
    }

    /*
     * DIESE METHODE BEWEGT DIE SCHÜSSE NACH OBEN UND ENTFERTN SIE WENN SIE OBER DER
     * SCENE SIND
     */
    public void moveShots() {
        for (ImageView shot : shots) {
            shot.setLayoutY(shot.getLayoutY() - 10);
            if (shot.getLayoutY() < 0) {
                shot.setLayoutX(5000);
                gamePane.getChildren().remove(shot);
            }
        }
    }

    /*
     * DIESE METHODE BEWEGT DIE ELEMENTE WIE ENEMIES UND STARS NACH UNTEN UND SETTET
     * SIE NEU WENN SIE UNTER DER SCENE SIND
     */
    public void moveElemntsDown(ImageView[] ImageViewObjectes, int[] velocities) {
        // Wenn Enemies dann keine Rotation
        if (ImageViewObjectes.equals(enemies)) {
            for (int n = 0; n < ImageViewObjectes.length; n++) {
                ImageViewObjectes[n].setLayoutY(ImageViewObjectes[n].getLayoutY() + velocities[n]);
                if (ImageViewObjectes[n].getLayoutY() > HIGHT) {
                    setElementNewPostion(ImageViewObjectes[n]);
                }
            }
        } else {
            for (int n = 0; n < ImageViewObjectes.length; n++) {
                ImageViewObjectes[n].setLayoutY(ImageViewObjectes[n].getLayoutY() + velocities[n]);
                ImageViewObjectes[n].setRotate(ImageViewObjectes[n].getRotate() + velocities[n]);
                if (ImageViewObjectes[n].getLayoutY() > HIGHT) {
                    setElementNewPostion(ImageViewObjectes[n]);
                }
            }
        }
    }

    /* GEMEINSAME SCHNITSTELLE, DIESE METHODE WIRD IN DER GAME LOOP AUFGERUFEN*/
    public void moveGameElements() {
        movePlayer();
        moveShots();
        moveElemntsDown(stars, starsVelocity);
        moveElemntsDown(enemies, enemiesAVelocity);
        moveElemntsDown(bigMeteors, MeteorVelocity);
        moveElemntsDown(smallMeteors, MeteorVelocity);
    }

    // REPOSITION//REPOSITION//REPOSITION//REPOSITION//REPOSITION//REPOSITION//REPOSITION//REPOSITION//REPOSITION//REPOSITION/REPOSITION//REPOSITION
    /* DIESE METHODE SITZT DEN PLYER AUF SEINE ORIGINALE POSITION */
    public void setStandartPLAYERPostion() {
        PLAYER.setLayoutX((WIDTH / 2) - 32);
        PLAYER.setLayoutY(HIGHT - 64);
    }

    /* DIESE METHODE SITZT DIE ELEMENTE WIEDER OBEN GANZ RANDOM BIS ZU -3500 AUF DIE Y Achse */
    public void setElementNewPostion(ImageView element) {

        element.setLayoutX(randomPositionGenerator.nextInt(900));
        element.setLayoutY(-1 * (randomPositionGenerator.nextInt(3000)));
    }

    /***************************************************************************************************/

    // COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION//COLLETION

    /**
     * WENN SCHÜSSE DIE FEINDE TREFFEN DANN SOLLEN DIE SCHÜSSE ENTFERTN WERDEN UND
     * DIE FEINDE NEU GESETTET
     */
    public void checkIfshotsCollide() {
        for (ImageView shot : shots) {
            for (ImageView enemy : enemies) {
                if (enemy.getBoundsInParent().intersects(shot.getBoundsInParent())) {
                    sounds.explosionSoundStop();
                    shot.setLayoutY(10000);
                    setElementNewPostion(enemy);
                    gamePane.getChildren().remove(shot);
                    score += 3;

                }
            }
            sounds.explosionSoundStart();

        }
    }

    /*
     * WENN DIE STERNE MIT DEM SPIELER KOLLIDIEREN DANN SOLLEN DIE STERNE NEU
     * GESETTET WERDEN UND DER SPIELER BEKOMMT EINEN PUNKT
     */
    public void checkIfStarsCollide() {
        for (ImageView star : stars) {
//            if (Player_RADIUS + STAR_RADIUS > realDistance(PLAYER.getLayoutX(), star.getLayoutX(), PLAYER.getLayoutY(),
//                    star.getLayoutY())) {
            if (star.getBoundsInParent().intersects(PLAYER.getBoundsInParent())) {
                if (score % 10 == 0) {
                    sounds.scoreSoundStop();
                    ;
                }
                setElementNewPostion(star);
                gamePane.getChildren().remove(scoreLabel);
                createScoreLabel();
                score++;
                if (score >= scoreToAchive) {
                    gameTimer.stop();
                    creatLevelUpScene();
                }
            }
        }
        sounds.scoreSoundStart();
    }

    /*
     * WENN DIE FEINDE MIT DEM SPIELER KOLLIDIEREN DANN SOLLEN DIE FEINDE NEU
     * GESETTET WERDEN UND DER SPIELER WIRD AUF SEINEM STANDRAT POSITION GESETTET
     */
    public void checkIfEnemiesCollide() {
        for (ImageView enemy : enemies) {
            if (Player_RADIUS + enemies_RADIUS > realDistance(enemy.getLayoutX(), PLAYER.getLayoutX(),
                    enemy.getLayoutY(), PLAYER.getLayoutY())) {
                sounds.explosionSoundStop();

                setElementNewPostion(enemy);
                lifesNumber--;
                loseLife();
                setStandartPLAYERPostion();
                setElementNewPostion(enemy);
            }
        }
        sounds.explosionSoundStart();
    }

    /*
     * WENN DIE METEOREN MIT DEM SPIELER KOLLIDIEREN DANN SOLLEN DIE METEOREN NEU
     * GESETTET WERDEN UND DER SPIELER WIRD AUF SEINEM STANDRAT POSITION GESETTET
     */
    public void checkIfMeteorsCollide() {
        for (ImageView smallmeteor : smallMeteors) {
            if (Player_RADIUS + smallMeteors_RADIUS > realDistance(PLAYER.getLayoutX(), smallmeteor.getLayoutX(),
                    PLAYER.getLayoutY(), smallmeteor.getLayoutY())) {
                lifesNumber--;
                loseLife();
                setStandartPLAYERPostion();
                setElementNewPostion(smallmeteor);
            }
        }

        for (ImageView bigmeteor : bigMeteors) {
            if (Player_RADIUS + bigMeteors_RADIUS > realDistance(PLAYER.getLayoutX(), bigmeteor.getLayoutX(),
                    PLAYER.getLayoutY(), bigmeteor.getLayoutY())) {
                lifesNumber--;
                loseLife();
                setStandartPLAYERPostion();
                setElementNewPostion(bigmeteor);
            }
        }
    }

    /*
     * DIESE METHODE HAT ALLE METHODEN HIER ZUSAMMEN DAMIT DER CODE NICHT RICHTIG
     * SPAGETTI WIRD :D
     */
    public void checkCollestion() {
        checkIfshotsCollide();
        // COLLESTION FUKTIONIERT NUR WENN DER PLAYER NICHT IM STANDRAT POSITION IST
        if (!((PLAYER.getLayoutX() == (WIDTH / 2) - 32) && (PLAYER.getLayoutY() == (HIGHT - 64)))) {
            checkIfStarsCollide();
            checkIfMeteorsCollide();
            checkIfEnemiesCollide();
        }
    }

    /* Dstance between Point 1 and Point 2 */
    public double realDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}

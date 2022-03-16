package view;

import java.util.ArrayList;
import java.util.List;

import Sounds.Sound;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;
import model.InfoLabel;
import model.SpaceInvaderButton;
import model.SpaceInvaderText;
import model.SpaceInvadersSubScene;

public class ViewManager {

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private static final int WIDTH = 900;
    private static final double HIGHT = 900;
    // DIESE X UND Y SIND UM DIE MBUTTONS ZUBESTIMMEN
    private final static int MENU_START_X_KOORFINATION = 50;
    private final static int MENU_START_Y_KOORFINATION = 230;
    // DIESE X UND Y SIND UM DIE LEVELBUTTONS ZUBESTIMMEN
    private final static int LEVELS_X_KOORFINATION = 200;
    private final static int LEVELS_Y_KOORFINATION = 70;
    private SpaceInvadersSubScene startScene;
    private SpaceInvadersSubScene scoreScene;
    private SpaceInvadersSubScene helpScene;
    private ImageView SpaceInvaderLogo01;
    private ImageView SpaceInvaderLogo02;
    private final static String Logo1_Path = "ProjecktPics/ViewElements/SpaceInvadersLogo.png";
    private final static String Logo2_Path = "ProjecktPics/ViewElements/SpaceInvadersLogo2.png";

    List<SpaceInvaderButton> menuButtons;
    List<SpaceInvaderButton> levelButtons;
    List<SpaceInvaderButton> exitButtons;
    private InfoLabel chooseLevel;
    private SpaceInvaderText welcomingText;
    private SpaceInvaderText movesTippsHelpScene;
    private SpaceInvaderText shootTippsHelpScene;
    private SpaceInvaderText playWay1HelpScene;
    private SpaceInvaderText playWay2HelpScene;
    private SpaceInvaderText giveItaTryTextHelpScene;

    private final static String BACKGROUND_IMAGE = "ProjecktPics/ViewElements/Matrix.gif";
    private Sound sounds;
    // NEEDED FOR THE HIDING/SHOWING LOGIC OF THE SUBSCENES IN THE MAIN MENU
    private SpaceInvadersSubScene sceneToHide;

    public ViewManager() {

        initializeViewManager();
        creatGameLogo();
        creatBackground();
        creatGUIScenes();
        creatMenuButton();
    }

    public void initializeViewManager() {
        sounds = new Sound();
        sounds.loadSounds();
        levelButtons = new ArrayList<>();
        menuButtons = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HIGHT);
        mainStage = new Stage();
        SpaceInvaderLogo01 = new ImageView(Logo1_Path);
        SpaceInvaderLogo02 = new ImageView(Logo2_Path);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Space Invader");
        mainStage.setResizable(false);

    }

    private void creatGameLogo() {
        mainPane.getChildren().add(SpaceInvaderLogo01);
        SpaceInvaderLogo01.setLayoutX(156);
        SpaceInvaderLogo01.setLayoutY(20);
        mainPane.getChildren().add(SpaceInvaderLogo02);
        SpaceInvaderLogo02.setLayoutX(500);
        SpaceInvaderLogo02.setLayoutY(70);

    }

    /*
     * THIS METHODE CALLS ALL SUBSCENE CREATION_METHODES LOOK AT THE NEXT 3 METHDOES
     */
    private void creatGUIScenes() {
        creatStartSubScene();
        createHelpSubScene();
        createscoreSubScene();
    }

    /* THIS METHODE CREATE THE START_SUBSCENE METHODE WHERE ALL LEVEL BUTTONS ARE */
    private void creatStartSubScene() {
        startScene = new SpaceInvadersSubScene();
        mainPane.getChildren().add(startScene);
        createStartButtons();

        // HIER IST EIN LABEL
        chooseLevel = new InfoLabel("CHOOSE A LEVEL");
        chooseLevel.setLayoutX(110);
        chooseLevel.setLayoutY(25);
        startScene.getPane().getChildren().add(chooseLevel);

    }

    /*
     * THIS METHODE CREATE THE START_SUBSCENE METHODE WHERE ALL SCORES ARE LEIDER
     * HABE ICH NICHT GESCHAFFT DIE ZU IMPLEMENTIEREN
     */
    private void createscoreSubScene() {
        scoreScene = new SpaceInvadersSubScene();
        mainPane.getChildren().add(scoreScene);
    }

    /*
     * THIS METHODE CREATE THE HELP SUBSCENE AND CALLS THE METHODE THAT CREATES ALL
     * THE TEXTS IN THE HELP_SUBSECNE
     */
    private void createHelpSubScene() {
        helpScene = new SpaceInvadersSubScene();
        createHelpTippsInHelpSubScene();
        mainPane.getChildren().add(helpScene);
    }

    /* THIS METHODE CREATES ALL THE TEXTS IN THE HELP_SUBSECNE */
    private void createHelpTippsInHelpSubScene() {
        creatSIWelcomingTextHelpSubScene();
        creatSIPlayWay1TextHelpSubScene();
        creatSIplayWay2TextHelpSubScene();
        creatSIMovesTippsTextHelpSubScene();
        creatSIShootTippsTextHelpSubScene();
        creatSIgiveItaTryTextHelpSubScene();
    }

    /*
     * THE NEXT 6 METHODES ARE THE CREATION FOR ALL TEXTS IN THE HELP SUBSCENE
     */
    /* 1 TEXT_METHODE */
    public void creatSIWelcomingTextHelpSubScene() {
        welcomingText = new SpaceInvaderText("Welcome to my game.\n      Enjoy!!", 90, 50, 36);
        helpScene.getPane().getChildren().add(welcomingText);
    }

    /* 2 TEXT_METHODE */
    public void creatSIPlayWay1TextHelpSubScene() {
        playWay1HelpScene = new SpaceInvaderText("*You need to catch as much Stars\n as possible until the win ", 25,
                140, 26);
        helpScene.getPane().getChildren().add(playWay1HelpScene);
    }

    /* 3 TEXT_METHODE */
    public void creatSIplayWay2TextHelpSubScene() {
        playWay2HelpScene = new SpaceInvaderText(
                "*You need to avoid collisions with\n everything which is as big as the size\n of the ship", 25, 230,
                26);
        helpScene.getPane().getChildren().add(playWay2HelpScene);
    }

    /* 4 TEXT_METHODE */
    public void creatSIMovesTippsTextHelpSubScene() {
        movesTippsHelpScene = new SpaceInvaderText(
                "*You can move with: A / W / S / D\n and shoot with: MOUSE but the shots\n are limited so be careful.. ",
                25, 320, 26);
        helpScene.getPane().getChildren().add(movesTippsHelpScene);
    }

    /* 5 TEXT_METHODE */
    public void creatSIShootTippsTextHelpSubScene() {
        shootTippsHelpScene = new SpaceInvaderText(
                "*Scoring Points helps you to win\n faster You can score when u\n shot the enemies  :( ", 25, 410, 26);
        helpScene.getPane().getChildren().add(shootTippsHelpScene);
    }

    /* 6 TEXT_METHODE */
    public void creatSIgiveItaTryTextHelpSubScene() {
        giveItaTryTextHelpScene = new SpaceInvaderText("*Why u don't give it a Try? :^D ", 25, 500, 26);
        helpScene.getPane().getChildren().add(giveItaTryTextHelpScene);
    }

    /*
     * ALL NEXT BUTTON METHODES ARE WITH AN EVENT HANDLER AND THE HANDLER IS
     * DIRECTLY IN THE IMPLEMENTATION
     */

    /** THIS METHODE CREATE THE START BUTTON AND ADDS IT IN THE menuButtons LIST */
    private void creatStartButton() {
        sounds.backgroundStop();

        SpaceInvaderButton startButton = new SpaceInvaderButton("START");
        // HERE is the METHODE FOR ADDING THE startButton in The StartButtonList
        addMenuButtons(startButton);
        // VERKNÜPFUNG ZWISCHEN START BUTTON UND DIE START_SUBSCENE
        startButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                sounds.backgroundStart();

                // THIS METHODE IS FOT THE TRANSATION BETWEEN THE DIFFRENT SUBSCENE
                showHideSubScene(startScene);
//                PlaySound(buttonSound);
            }
        });
    }

    /** THIS METHODE CREATE THE SCORE BUTTON AND ADDS IT IN THE menuButtons LIST */
//    private void creatScoreButton() {
//
//        SpaceInvaderButton scoreButton = new SpaceInvaderButton("SCORE");
//        addMenuButtons(scoreButton);
//        scoreButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                showHideSubScene(scoreScene);
//            }
//        });
//    }

    /** THIS METHODE CREATE THE HELP BUTTON AND ADDS IT IN THE menuButtons LIST */
    private void creatHelpButton() {

        SpaceInvaderButton helpButton = new SpaceInvaderButton("HELP");
        addMenuButtons(helpButton);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showHideSubScene(helpScene);

            }
        });
    }

    /** THIS METHODE CREATE THE EXITBUTTON AND ADDS IT IN THE menuButtons LIST */
    private void creatExitButton() {
        SpaceInvaderButton ExitButton = new SpaceInvaderButton("EXIT");
        addMenuButtons(ExitButton);
        ExitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//                showHideSubScene(exitScene);
                mainStage.close();

            }
        });

    }

    /* THIS METHODE CALL THE LAST THREE METHODE WHICH CREATE THE MenuButtons */
    // SOLCHE METHODEN KOMMEN HÄUFIGER VOR WEIL ICH ES BESSER UND KLARER FAND
    private void creatMenuButton() {
        creatStartButton();
//        creatScoreButton();
        creatHelpButton();
        creatExitButton();
    }

    /*
     * THIS METHODE IS THE METHOD FOR ADDING ALL THE BUTTONS IN THE menuButton LIST
     */
    private void addMenuButtons(SpaceInvaderButton button) {
        button.setLayoutX(MENU_START_X_KOORFINATION);
        // menuButtons.size() * 135 ist einfach die Verschiebung nach unten auf der
        // Y-Achse
        button.setLayoutY(MENU_START_Y_KOORFINATION + menuButtons.size() * 135);
        menuButtons.add(button);
        mainPane.getChildren().add(button);

    }

    /* LEVEL 1 BUTTON IN THE STARTSCENE */
    public void creatLevelOneButton() {

        SpaceInvaderButton levelOneButton = new SpaceInvaderButton("Level 1");
        addStartButtons(levelOneButton);

        // VERKNÜPFUNG ZWISCHEN START BUTTON UND DIE START_SUBSCENE
        levelOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sounds.backgroundStop();

                // A NEW GameViewManager IS BEING CREATED WHEN LEVEL 1 IS KLICKED
                // THE 1 IN THE CONSTRUCTOR IS FOR TELLEING THE NEXT CLASS WHICH LEVEL IS
                // CHOOSEN
                GameViewManager level_1 = new GameViewManager(1);
                // THIS METHODE IS IN THE GameViewManager CLASS AND IT SET A NEW SCENE WHERE THE
                // GAME IS STARTING
                // IN THE creatNewGame METHODE IS ALSO METHODES CALLED LIKE setLevelSetting and
                // CreateGameElements and CreateGameLoop
                // THE KONCEPT IS THE SAME FOR ALL LEVEL BUTTONS BUT THE DIFFRENCE IS THE LEVEL
                // PARAMETER IN THE CONSTRUCTOR OF The GameViewManagerObkecjt
                level_1.creatNewGame(mainStage);
                mainStage.close();
            }
        });
    }

    /* SAME STORY LIKE IN createLevelOneButton(ONE METHODE BEFOR) */
    public void creatLevelTowButton() {

        SpaceInvaderButton levelTowButton = new SpaceInvaderButton("Level 2");
        addStartButtons(levelTowButton);
        // VERKNÜPFUNG ZWISCHEN START BUTTON UND DIE START_SUBSCENE
        levelTowButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                sounds.backgroundStop();

                GameViewManager level_2 = new GameViewManager(2);
                level_2.creatNewGame(mainStage);
                mainStage.close();
            }
        });
    }

    /* SAME STORY LIKE IN createLevelOneButton(TOW METHODE BEFOR) */
    public void creatLevelThreeButton() {
        SpaceInvaderButton levelThreeButton = new SpaceInvaderButton("Level 3");
        addStartButtons(levelThreeButton);
        // VERKNÜPFUNG ZWISCHEN START BUTTON UND DIE START_SUBSCENE
        levelThreeButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                sounds.backgroundStop();

                GameViewManager level_3 = new GameViewManager(3);
                level_3.creatNewGame(mainStage);
                mainStage.close();

            }
        });

    }

    /* SAME STORY LIKE IN createLevelOneButton(THREE METHODE BEFOR) */
    public void creatLevelFourButton() {

        SpaceInvaderButton levelFourButton = new SpaceInvaderButton("Level 4");
        addStartButtons(levelFourButton);
        // VERKNÜPFUNG ZWISCHEN START BUTTON UND DIE START_SUBSCENE
        levelFourButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                sounds.backgroundStop();

                GameViewManager level_4 = new GameViewManager(4);

                level_4.creatNewGame(mainStage);
                mainStage.close();

            }
        });
    }

    /*
     * THIS METHODE CREATE ALL THE LEVEL BUTTONS AND ITS CALLED IN THE
     * creatStartSceneSubScene METHOD ( THE CREATION OF THE START SCENE WHERE ALL
     * LEVEL_BUTTONS ARE ADDED
     */
    public void createStartButtons() {
        creatLevelOneButton();
        creatLevelTowButton();
        creatLevelThreeButton();
        creatLevelFourButton();

    }

//    public void PlaySound(String path) {
//        SoundM playerLaser = new SoundM(path, 0.1);
//        playerLaser.getSound().play();
//
//    }
//    
    /* THIS METHODE ADDS ALL THE LEVEL BUTTONS 1 - 4 IN THE levelButtonsList */
    private void addStartButtons(SpaceInvaderButton button) {
        levelButtons.add(button);
        button.setLayoutX(LEVELS_X_KOORFINATION);
        // menuButtons.size() * 135 ist einfach die Verschiebung nach unten auf der
        // Y-Achse
        button.setLayoutY(LEVELS_Y_KOORFINATION + levelButtons.size() * 90);

        startScene.getPane().getChildren().add(button);
    }

    /*
     * THIS METHIDE TAKES A SUNSCENE AS A PARAMETER AND CHECK IF A SUBSCENE IS
     * HIDDEN OR SHOWN AND ITS TAKE SHOWN SCENE BACK AND LET ATHOR APPEARS
     * 
     * 
     */
    private void showHideSubScene(SpaceInvadersSubScene subScene) {
        // WHEN A SCENE IS SHOWN THEN HIDE IT
        if (sceneToHide != null) {
            sceneToHide.moveSubScene();
        }
        // AFTER HIDING IT SHOW THE OTHER ONE THE U WANT TO SEE
        subScene.moveSubScene();
        sceneToHide = subScene;
        // YOU CAN CHEK THE EFFECT WHEN YOU CHANGE BETWEEN SCENES IN THE MENU
    }

    /* THIS METHODE CREATE THE BACKGROUND */
    public void creatBackground() {
        // HIER IST DIE PRO METHODE
        // Ich habe hier mit dem String PATH BACKGROUND_IMAGE versucht und hat nicht
        // funktioniert, Ich habe wirklich alles versucht und ging nicht mit Pfade und
        // genau so für sounds..
        Image background = new Image(BACKGROUND_IMAGE, WIDTH, HIGHT, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(backgroundImage));
    }

    public Stage getMainStage() {
        return mainStage;
    }

}

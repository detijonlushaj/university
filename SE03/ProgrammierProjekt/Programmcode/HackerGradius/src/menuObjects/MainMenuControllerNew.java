package menuObjects;

import gameObjects.gameControllers.GameControllerLevel1;
import gameObjects.gameControllers.GameControllerLevel2;
import gameObjects.gameControllers.GameControllerLevel3;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * Creates the main menu
 * The basic function of the buttons is to set the visibility of the buttons to true or false
 * */

public class MainMenuControllerNew {
    int lvl = 1;
    int diff = 1;
    GameControllerLevel1 gc1 = new GameControllerLevel1();
    GameControllerLevel2 gc2 = new GameControllerLevel2();
    GameControllerLevel3 gc3 = new GameControllerLevel3();

    //Init the menu
    public void initMenu(Stage stage, String mainLabel) {
        Pane root = new Pane();
        Scene mainScene;

        createBackground bg = new createBackground("/gameObjects/GameRessources/Background_Game.gif");

        createLabel titleLabel = new createLabel(mainLabel,40,350,25);
        createButton buttonSelection = new createButton("Selection",100,150);
        createButton buttonControls = new createButton("Controls",100,275);
        createButton buttonExit = new createButton("Exit",100,400);
        createButton buttonLevelOne = new createButton("Level 1",400,150);
        createButton buttonLevelTwo = new createButton("Level 2",400,275);
        createButton buttonLevelThree = new createButton("Level 3",400,400);
        createButton buttonEasy = new createButton("Easy",700,150);
        createButton buttonMedium = new createButton("Medium",700,275);
        createButton buttonHard = new createButton("Hard",700,400);
        createButton buttonPlay = new createButton("Play",400,500);
        createLabel movementLabel = new createLabel("Movement:",30,400,150);
        createLabel shootLabel = new createLabel("Shoot:",30,400,225);
        createLabel wasdLabel = new createLabel("W,A,S,D",30,700,150);
        createLabel spaceLabel = new createLabel("SPACE",30,700,225);
        createLabel pauseLabel = new createLabel("Pause:",30,400,300);
        createLabel pLabel = new createLabel("P",30,700,300);
        createLabel restartLabel = new createLabel("Restart:",30,400,375);
        createLabel rLabel = new createLabel("R",30,700,375);
        createLabel btmmLabel = new createLabel("Back to main menu:",30,400,450);
        createLabel escLabel = new createLabel("ESC",30,700,450);


        buttonLevelOne.getButton().setVisible(false);
        buttonLevelTwo.getButton().setVisible(false);
        buttonLevelThree.getButton().setVisible(false);
        buttonEasy.getButton().setVisible(false);
        buttonMedium.getButton().setVisible(false);
        buttonHard.getButton().setVisible(false);
        buttonPlay.getButton().setVisible(false);
        movementLabel.getLabel().setVisible(false);
        shootLabel.getLabel().setVisible(false);
        wasdLabel.getLabel().setVisible(false);
        spaceLabel.getLabel().setVisible(false);
        pauseLabel.getLabel().setVisible(false);
        pLabel.getLabel().setVisible(false);
        restartLabel.getLabel().setVisible(false);
        rLabel.getLabel().setVisible(false);
        btmmLabel.getLabel().setVisible(false);
        escLabel.getLabel().setVisible(false);

        //Action on SelectionButton
        buttonSelection.getButton().setOnAction(event -> {
            movementLabel.getLabel().setVisible(false);
            shootLabel.getLabel().setVisible(false);
            wasdLabel .getLabel().setVisible(false);
            spaceLabel.getLabel().setVisible(false);
            pauseLabel.getLabel().setVisible(false);
            pLabel.getLabel().setVisible(false);
            restartLabel.getLabel().setVisible(false);
            rLabel.getLabel().setVisible(false);
            btmmLabel.getLabel().setVisible(false);
            escLabel.getLabel().setVisible(false);
            buttonLevelOne.getButton().setVisible(true);
            buttonLevelTwo.getButton().setVisible(true);
            buttonLevelThree.getButton().setVisible(true);
        });
        //Action on ControlsButton
        buttonControls.getButton().setOnAction(event -> {
            //Hier werden dann die Controls an gezeigt
            buttonLevelOne.getButton().setVisible(false);
            buttonLevelTwo.getButton().setVisible(false);
            buttonLevelThree.getButton().setVisible(false);
            buttonEasy.getButton().setVisible(false);
            buttonMedium.getButton().setVisible(false);
            buttonHard.getButton().setVisible(false);
            buttonPlay.getButton().setVisible(false);
            movementLabel.getLabel().setVisible(true);
            shootLabel.getLabel().setVisible(true);
            wasdLabel .getLabel().setVisible(true);
            spaceLabel.getLabel().setVisible(true);
            pauseLabel.getLabel().setVisible(true);
            pLabel.getLabel().setVisible(true);
            restartLabel.getLabel().setVisible(true);
            rLabel.getLabel().setVisible(true);
            btmmLabel.getLabel().setVisible(true);
            escLabel.getLabel().setVisible(true);
        });
        //Action on ExitButton
        buttonExit.getButton().setOnAction(event -> {
            System.exit(0);
        });
        //Action on LevelOneButton
        buttonLevelOne.getButton().setOnAction(event -> {
            lvl = 1;
            buttonEasy.getButton().setVisible(true);
            buttonMedium.getButton().setVisible(true);
            buttonHard.getButton().setVisible(true);
        });
        //Action on LevelTwoButton
        buttonLevelTwo.getButton().setOnAction(event -> {
            lvl = 2;
            buttonEasy.getButton().setVisible(true);
            buttonMedium.getButton().setVisible(true);
            buttonHard.getButton().setVisible(true);
        });
        //Action on LevelThreeButton
        buttonLevelThree.getButton().setOnAction(event -> {
            lvl = 3;
            buttonEasy.getButton().setVisible(true);
            buttonMedium.getButton().setVisible(true);
            buttonHard.getButton().setVisible(true);
        });
        //Action on EasyButton
        buttonEasy.getButton().setOnAction(event -> {
            diff = 1;
            buttonPlay.getButton().setVisible(true);
        });
        //Action on MediumButton
        buttonMedium.getButton().setOnAction(event -> {
            diff = 2;
            buttonPlay.getButton().setVisible(true);
        });
        //Action on HardButton
        buttonHard.getButton().setOnAction(event -> {
            diff = 3;
            buttonPlay.getButton().setVisible(true);
        });
        ////Action on playButton
        buttonPlay.getButton().setOnAction(event -> {
            //gc2.gameStart(stage, diff);
            whichLevelWhichDiff(stage,lvl,diff);
        });


        root.getChildren().addAll(bg.getBackground(),titleLabel.getLabel(),buttonSelection.getButton(),buttonControls.getButton(),buttonExit.getButton(),
                buttonLevelOne.getButton(),buttonLevelTwo.getButton(),buttonLevelThree.getButton(),buttonEasy.getButton(),buttonMedium.getButton(),buttonHard.getButton(),
                buttonPlay.getButton(), movementLabel.getLabel(), shootLabel.getLabel(), wasdLabel.getLabel(), spaceLabel.getLabel(), pauseLabel.getLabel(), pLabel.getLabel(),
                restartLabel.getLabel(), rLabel.getLabel(), btmmLabel.getLabel(), escLabel.getLabel());
        mainScene = new Scene(root,1000,600);

        stage.setResizable(false);
        stage.setScene(mainScene);
        stage.setTitle("Hacker Gradius");
        stage.show();

    }
    //Starts the game with the right parameters
    public void whichLevelWhichDiff(Stage stage, int level, int diff) {
        if(level == 1) {
            gc1.gameStart(stage, diff);
        } else if (level == 2) {
            gc2.gameStart(stage, diff);
        } else if (level == 3) {
            gc3.gameStart(stage, diff);
        } else {
            System.out.println("Error 404");
        }
    }
}

package gamelogic;

import gui.GameMenuGUI;
import gui.finishedGameGUI;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Levels {
    private static GameField gameField = new GameField();
    private static int level =1;
    private static PacMan pacman = new PacMan();
    private final static String MOVERIGHTIMG = "res/images/Pacman.png";
    private final static String MOVEDOWNIMG = "res/images/PacmanDOWN.png";
    private final static String MOVELEFTIMG = "res/images/PacmanLEFT.png";
    private final static String MOVEUPIMG = "res/images/PacmanUP.png";
    
    private static Ghost ghostRED = new Ghost();
    private static Ghost ghostPINK = new Ghost();
    private static Ghost ghostBLUE = new Ghost();
    private static Ghost ghostGREEN = new Ghost();
    private static Ghost ghostYELLOW = new Ghost();
    private static Ghost ghostPURPLE = new Ghost();
    private final static String GHOSTREDIMG = "res/images/ghostRED.png";
    private final static String GHOSTPINKIMG = "res/images/ghostPINK.png";
    private final static String GHOSTBLUEIMG = "res/images/ghostBLUE.png";
    private final static String GHOSTGREENIMG = "res/images/ghostGREEN.png";
    private final static String GHOSTYELLOWIMG = "res/images/ghostYELLOW.png";
    private final static String GHOSTPURPLEIMG = "res/images/ghostPURPLE.png";
   
    private static Heart heart1 = new Heart();
    private static Heart heart2 = new Heart();
    private static Heart heart3 = new Heart();
    private final static String HEARTIMAGE = "res/images/actualHealth.png";
    private final static String LOSTHEARTIMAGE = "res/images/leftHealth.png";
    
    private static SoundPlayer soundPlayer;

    
    public static void loadSounds() {
        soundPlayer = new SoundPlayer();
        soundPlayer.loadSounds();
    }
    
    public static void loadImages() {
        //set Pacman
        pacman.setImage(MOVERIGHTIMG);
        pacman.setMoveDownImg(MOVEDOWNIMG);
        pacman.setMoveUpImg(MOVEUPIMG);
        pacman.setMoveLeftImg(MOVELEFTIMG);
        pacman.setMoveRightImg(MOVERIGHTIMG);
        
        //set Ghosts
        ghostRED.setImage(GHOSTREDIMG);
        ghostPINK.setImage(GHOSTPINKIMG);
        ghostBLUE.setImage(GHOSTBLUEIMG);
        ghostGREEN.setImage(GHOSTGREENIMG);
        ghostYELLOW.setImage(GHOSTYELLOWIMG);
        ghostPURPLE.setImage(GHOSTPURPLEIMG);
        
        // set HeartSprite
        heart1.setImage(HEARTIMAGE);
        heart1.setLostHeartImage(LOSTHEARTIMAGE);
        heart1.setPosition(10, 15);
        heart2.setImage(HEARTIMAGE);
        heart2.setLostHeartImage(LOSTHEARTIMAGE);
        heart2.setPosition(55, 15);
        heart3.setImage(HEARTIMAGE);
        heart3.setLostHeartImage(LOSTHEARTIMAGE);
        heart3.setPosition(100, 15);
    }
    
    private static void spawnPacman() {
        // set Pacman
        pacman.setReq_dx(0);
        pacman.setReq_dy(0);
        pacman.getInputList().clear();
        pacman.getVelocity().set(0, 0);
        pacman.setPosition(200, 80);
    }
    
    private static void renderScoreboard(GraphicsContext scoreboardContext, Canvas scoreboardCanvas) {
        //clearing Scoreboard
        scoreboardContext.setFill(Color.GREEN);
        scoreboardContext.fillRect(0, -40, scoreboardCanvas.getWidth(), scoreboardCanvas.getHeight());
        scoreboardContext.setFill(Color.BLACK);
        scoreboardContext.fillRect(0, 10, scoreboardCanvas.getWidth(), scoreboardCanvas.getHeight());
        
        // render Hearts
        if(pacman.getLife() < 3) {
            scoreboardContext.drawImage(heart3.getLostHeart(), 100, 15);
        } else {
            heart3.render(scoreboardContext);
        }
        if(pacman.getLife() < 2) {
            scoreboardContext.drawImage(heart3.getLostHeart(), 55, 15);
        } else {
            heart2.render(scoreboardContext);
        }
        heart1.render(scoreboardContext);
        
        // render Level and Score Counter
        scoreboardContext.setFill(Color.WHITE);
        scoreboardContext.fillText("Score:    " + pacman.getScore(), 300, 35);
        scoreboardContext.fillText("Level:    " + level, 175, 35);
   
    }
    
    private static void exitIfPacmanIsDeath(Stage primaryStage, AnimationTimer timer) {
        if(pacman.getLife()<1) {
            timer.stop();
            GameMenuGUI.setStage(primaryStage);
            pacman.setLife(3);
            pacman.setScore(0);
            level = 1;
        }
    }
    
    public static void startGame(Canvas scoreboardCanvas, Canvas gameCanvas, GraphicsContext gameFieldContext, GraphicsContext scoreboardContext, Scene gameScene, Stage primaryStage){
        // set validKeys only 1 time at Start of Game
        pacman.setValidMovementKeys();
        //load Images only 1 time at Start of Game
        loadImages();
        //load Sounds only 1 time at Start of Game
        loadSounds();
        
        // set levelData
        // LEVEL 1
        short[] levelData = {
                                                   //M
             0,  0, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,  0,  0,
             0, 19, 16, 16, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 16, 22,  0,
            19, 16, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 22,
            17, 16, 16, 24, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 24, 16, 20,
            17, 16, 20,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0, 17, 20, 
            17, 16, 20,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0, 17, 20, // obere Mitte
            17, 16, 20,  0, 17, 16, 16, 24, 24, 24, 24, 24, 24, 24, 16, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 25, 16, 20,  0,  0,  0,  0,  0,  0,  0, 17, 16, 28,  0, 17, 20,
            17, 16, 20,  0,  0, 17, 20,  0, 19, 18, 18, 18, 22,  0, 17, 20,  0,  0, 17, 20,
            17, 16, 16, 18, 18, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 18, 18, 16, 20,
            17, 16, 16, 24, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 24, 16, 20, // Mitte
            17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 24, 24, 18, 16, 16, 16, 16, 16, 18, 24, 24, 20,  0, 17, 20,
            17, 16, 20,  0, 21,  0, 0,  17, 16, 16, 16, 16, 16, 20,  0,  0, 21,  0, 17, 20, // untere Mitte
            17, 16, 20,  0, 21,  0, 19, 16, 24, 24, 24, 24, 24, 16, 22,  0, 21,  0, 17, 20,
            17, 16, 20,  0, 17, 18, 16, 20,  0,  0,  0,  0,  0, 17, 16, 18, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 16, 16, 16, 18, 18, 18, 18, 18, 16, 16, 16, 20,  0, 17, 20,
            25, 24, 28,  0, 25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28,  0, 25, 28
                                                   //M
        };
        gameField.setLevelData(levelData);
        gameField.initLevel();
        spawnPacman();
        
        //set GhostRED
        ghostRED.setPosition(200, 200);
        ghostRED.setStartDirection(ghostRED.MOVEDOWN);
        ghostRED.setGhostDifficulty(ghostRED.level1Extra);
        
        //set GhostPINK
        ghostPINK.setPosition(200, 200);
        ghostPINK.setStartDirection(ghostPINK.MOVEUP);
        ghostPINK.setGhostDifficulty(ghostPINK.level1);

        //set GhostBLUE
        ghostBLUE.setPosition(200, 200);
        ghostBLUE.setStartDirection(ghostBLUE.MOVERIGHT);
        ghostBLUE.setGhostDifficulty(ghostBLUE.level1);
       
        AnimationTimer gameloop = new AnimationTimer() {
            public void handle(long nanotime) {
                if (pacman.getScore() == 321) {
                    this.stop();
                    System.out.println("Level " + level + " erfolgreich abgeschlossen!");
                    ++level;
                    pacman.setLife(3);
                    setlevel2(scoreboardCanvas, gameCanvas, gameFieldContext, scoreboardContext, gameScene, primaryStage);
                }
               // level 1
               pacman.movePacMan(gameScene, gameField);
               ghostRED.moveGhost(gameScene, gameField);
               ghostRED.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostPINK.moveGhost(gameScene, gameField);
               ghostPINK.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostBLUE.moveGhost(gameScene, gameField);
               ghostBLUE.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               
               exitIfPacmanIsDeath(primaryStage, this);
               
               //clearing the canvas and drawing the updated GameField and Sprite Positions 
               
               renderScoreboard(scoreboardContext, scoreboardCanvas);
               gameFieldContext.setFill(Color.BLACK);
               gameFieldContext.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
               
               gameField.drawMaze(gameFieldContext);
               pacman.render(gameFieldContext);
               ghostRED.render(gameFieldContext);
               ghostPINK.render(gameFieldContext);
               ghostBLUE.render(gameFieldContext);   
            }

        };

        gameloop.start();
    }
    
    private static void setlevel2(Canvas scoreboardCanvas, Canvas gameCanvas, GraphicsContext gameFieldContext, GraphicsContext scoreboardContext, Scene gameScene, Stage primaryStage){
        soundPlayer.resetLvltUptSound();
        soundPlayer.lvlUpSound();
        // set gameField
        short[] levelData = {
                                                   //M
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,  0,  0,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,  0,  0,
            17, 16, 16, 16, 24, 24, 24, 24, 24, 28,  0, 25, 24, 24, 24, 24, 24, 16, 18, 22,
            17, 16, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 20,
            17, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 16, 16, 20, 
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // obere Mitte
            17, 16, 16, 16, 16, 16, 16, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 16, 16, 20,
            17, 24, 24, 24, 16, 16, 20,  0,  0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 20,
            21,  0,  0,  0, 17, 16, 20,  0, 19, 18, 18, 18, 22,  0, 17, 16, 16, 16, 16, 20,
            17, 18, 18, 18, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 24, 28, // Mitte
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 20,  0,  0,
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 18, 22,
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // untere Mitte
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 24, 24, 16, 16, 20,
             0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0,  0, 17, 16, 20,
             0,  0, 25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28,  0,  0, 25, 24, 28
                                                   //M
        };
        
        gameField.setLevelData(levelData);
        gameField.initLevel();
        spawnPacman();
        
        //set GhostRED
        ghostRED.setPosition(200, 200);
        ghostRED.setStartDirection(ghostRED.MOVEDOWN);
        ghostRED.setGhostDifficulty(ghostRED.level1);
        
        //set GhostPINK
        ghostPINK.setPosition(200, 200);
        ghostPINK.setStartDirection(ghostPINK.MOVEUP);
        ghostPINK.setGhostDifficulty(ghostPINK.level1);

        //set GhostBLUE
        ghostBLUE.setPosition(200, 200);
        ghostBLUE.setStartDirection(ghostBLUE.MOVERIGHT);
        ghostBLUE.setGhostDifficulty(ghostBLUE.level1);
        
        //set GhostGREEN
        ghostGREEN.setPosition(200, 200);
        ghostGREEN.setStartDirection(ghostGREEN.MOVELEFT);
        ghostGREEN.setGhostDifficulty(ghostGREEN.level1);

        
       
        AnimationTimer gameloop = new AnimationTimer() {
            public void handle(long nanotime) {
                if (pacman.getScore() == 321+350) {
                    this.stop();
                    System.out.println("Level " + level + " erfolgreich abgeschlossen!");
                    ++level;
                    pacman.setLife(3);
                    setlevel3(scoreboardCanvas, gameCanvas, gameFieldContext, scoreboardContext, gameScene, primaryStage);

                }
               // level 1
               pacman.movePacMan(gameScene, gameField);
               ghostRED.moveGhost(gameScene, gameField);
               ghostRED.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostPINK.moveGhost(gameScene, gameField);
               ghostPINK.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostBLUE.moveGhost(gameScene, gameField);
               ghostBLUE.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostGREEN.moveGhost(gameScene, gameField);
               ghostGREEN.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               exitIfPacmanIsDeath(primaryStage, this);

               
               //clearing the canvas and drawing the updated GameField and Sprite Positions     
               renderScoreboard(scoreboardContext, scoreboardCanvas);
               gameFieldContext.setFill(Color.BLACK);
               gameFieldContext.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
               // drawing the new updated GameField and Sprite Positions
               gameField.drawMaze(gameFieldContext);
               pacman.render(gameFieldContext);
               ghostRED.render(gameFieldContext);
               ghostPINK.render(gameFieldContext);
               ghostBLUE.render(gameFieldContext);   
               ghostGREEN.render(gameFieldContext);
            }

        };

        gameloop.start();
    }
    
    private static void setlevel3(Canvas scoreboardCanvas, Canvas gameCanvas, GraphicsContext gameFieldContext, GraphicsContext scoreboardContext, Scene gameScene, Stage primaryStage){
        soundPlayer.resetLvltUptSound();
        soundPlayer.lvlUpSound();
        // set gameField
        short[] levelData = {
                                                    //M
            0,  0, 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,  0,  0,
            0, 19, 16, 16, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 16, 22,  0,
            19, 16, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 22,
            17, 16, 16, 24, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 24, 16, 20,
            17, 16, 20,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0, 17, 20, 
            17, 16, 20,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0, 17, 20, // obere Mitte
            17, 16, 20,  0, 17, 16, 16, 24, 24, 24, 24, 24, 24, 24, 16, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 25, 16, 20,  0,  0,  0,  0,  0,  0,  0, 17, 16, 28,  0, 17, 20,
            17, 16, 20,  0,  0, 17, 20,  0, 19, 18, 18, 18, 22,  0, 17, 20,  0,  0, 17, 20,
            17, 16, 16, 18, 18, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 18, 18, 16, 20,
            17, 16, 16, 24, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 24, 16, 20, // Mitte
            17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 24, 24, 18, 16, 16, 16, 16, 16, 18, 24, 24, 20,  0, 17, 20,
            17, 16, 20,  0, 21,  0, 0,  17, 16, 16, 16, 16, 16, 20,  0,  0, 21,  0, 17, 20, // untere Mitte
            17, 16, 20,  0, 21,  0, 19, 16, 24, 24, 24, 24, 24, 16, 22,  0, 21,  0, 17, 20,
            17, 16, 20,  0, 17, 18, 16, 20,  0,  0,  0,  0,  0, 17, 16, 18, 20,  0, 17, 20,
            17, 16, 20,  0, 17, 16, 16, 16, 18, 18, 18, 18, 18, 16, 16, 16, 20,  0, 17, 20,
            25, 24, 28,  0, 25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28,  0, 25, 28
                                                    //M
        };
        
        gameField.setLevelData(levelData);
        gameField.initLevel();
        spawnPacman();
        
        //set GhostRED
        ghostRED.setPosition(200, 200);
        ghostRED.setStartDirection(ghostRED.MOVEDOWN);
        ghostRED.setGhostDifficulty(ghostRED.level1Extra);
        
        //set GhostPINK
        ghostPINK.setPosition(200, 200);
        ghostPINK.setStartDirection(ghostPINK.MOVEUP);
        ghostPINK.setGhostDifficulty(ghostPINK.level1Extra);

        //set GhostBLUE
        ghostBLUE.setPosition(200, 200);
        ghostBLUE.setStartDirection(ghostBLUE.MOVERIGHT);
        ghostBLUE.setGhostDifficulty(ghostBLUE.level2);
        
        //set GhostGREEN
        ghostGREEN.setPosition(200, 200);
        ghostGREEN.setStartDirection(ghostGREEN.MOVELEFT);
        ghostGREEN.setGhostDifficulty(ghostGREEN.level2);
        
        //set GhostYELLOW
        ghostYELLOW.setPosition(200, 200);
        ghostYELLOW.setStartDirection(ghostYELLOW.MOVELEFT);
        ghostYELLOW.setGhostDifficulty(ghostYELLOW.level2);

        
       
        AnimationTimer gameloop = new AnimationTimer() {
            public void handle(long nanotime) {
                if (pacman.getScore() == 321+350+321) {
                    this.stop();
                    ++level;
                    System.out.println("Level " + level + " erfolgreich abgeschlossen!");
                    pacman.setLife(3);
                    setlevel4(scoreboardCanvas, gameCanvas, gameFieldContext, scoreboardContext, gameScene, primaryStage);

                }
               // level 1
               pacman.movePacMan(gameScene, gameField);
               ghostRED.moveGhost(gameScene, gameField);
               ghostRED.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostPINK.moveGhost(gameScene, gameField);
               ghostPINK.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostBLUE.moveGhost(gameScene, gameField);
               ghostBLUE.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostGREEN.moveGhost(gameScene, gameField);
               ghostGREEN.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostYELLOW.moveGhost(gameScene, gameField);
               ghostYELLOW.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               exitIfPacmanIsDeath(primaryStage, this);

               
               //clearing the canvas and drawing the updated GameField and Sprite Positions     
               renderScoreboard(scoreboardContext, scoreboardCanvas);
               gameFieldContext.setFill(Color.BLACK);
               gameFieldContext.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
               gameFieldContext.setFill(Color.BLACK);
               gameFieldContext.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());

               
               gameField.drawMaze(gameFieldContext);
               pacman.render(gameFieldContext);
               ghostRED.render(gameFieldContext);
               ghostPINK.render(gameFieldContext);
               ghostBLUE.render(gameFieldContext);   
               ghostGREEN.render(gameFieldContext);
               ghostYELLOW.render(gameFieldContext);
            }

        };

        gameloop.start();
    }
    
    private static void setlevel4(Canvas scoreboardCanvas, Canvas gameCanvas, GraphicsContext gameFieldContext, GraphicsContext scoreboardContext, Scene gameScene, Stage primaryStage){
        soundPlayer.resetLvltUptSound();
        soundPlayer.lvlUpSound();
        // set gameField
        short[] levelData = {
                                                    //M
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,  0,  0,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 20,  0,  0,
            17, 16, 16, 16, 24, 24, 24, 24, 24, 28,  0, 25, 24, 24, 24, 24, 24, 16, 18, 22,
            17, 16, 16, 20,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 17, 16, 20,
            17, 16, 16, 16, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 16, 16, 20, 
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // obere Mitte
            17, 16, 16, 16, 16, 16, 16, 24, 24, 24, 24, 24, 24, 24, 16, 16, 16, 16, 16, 20,
            17, 24, 24, 24, 16, 16, 20,  0,  0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 20,
            21,  0,  0,  0, 17, 16, 20,  0, 19, 18, 18, 18, 22,  0, 17, 16, 16, 16, 16, 20,
            17, 18, 18, 18, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 24, 28, // Mitte
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 20,  0,  0,
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 18, 22,
            17, 16, 16, 16, 16, 16, 20,  0, 17, 16, 16, 16, 20,  0, 17, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 16, 18, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // untere Mitte
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 24, 24, 16, 16, 20,
            0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,  0,  0, 17, 16, 20,
            0,  0, 25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28,  0,  0, 25, 24, 28
                                                   //M
        };
        
        gameField.setLevelData(levelData);
        gameField.initLevel();
        spawnPacman();
        
        //set GhostRED
        ghostRED.setPosition(200, 200);
        ghostRED.setStartDirection(ghostRED.MOVEDOWN);
        ghostRED.setGhostDifficulty(ghostRED.level2Extra);
        
        //set GhostPINK
        ghostPINK.setPosition(200, 200);
        ghostPINK.setStartDirection(ghostPINK.MOVEUP);
        ghostPINK.setGhostDifficulty(ghostPINK.level2);

        //set GhostBLUE
        ghostBLUE.setPosition(200, 200);
        ghostBLUE.setStartDirection(ghostBLUE.MOVERIGHT);
        ghostBLUE.setGhostDifficulty(ghostBLUE.level2);
        
        //set GhostGREEN
        ghostGREEN.setPosition(200, 200);
        ghostGREEN.setStartDirection(ghostGREEN.MOVELEFT);
        ghostGREEN.setGhostDifficulty(ghostGREEN.level2);
        
        //set GhostYELLOW
        ghostYELLOW.setPosition(200, 200);
        ghostYELLOW.setStartDirection(ghostYELLOW.MOVELEFT);
        ghostYELLOW.setGhostDifficulty(ghostYELLOW.level2);
        
        //set GhostPURPLE
        ghostPURPLE.setPosition(200, 200);
        ghostPURPLE.setStartDirection(ghostPURPLE.MOVELEFT);
        ghostPURPLE.setGhostDifficulty(ghostPURPLE.level2);
        
       
        AnimationTimer gameloop = new AnimationTimer() {
            public void handle(long nanotime) {
                if (pacman.getScore() == 321+350+321+350) {   
                    stop();
                    System.out.println("Level " + level + " erfolgreich abgeschlossen!");
                    level = 1;
                    pacman.setScore(0);
                    soundPlayer.finishSong();
                    finishedGameGUI.setStage(primaryStage, soundPlayer);

                }
               // level 1
               pacman.movePacMan(gameScene, gameField);
               ghostRED.moveGhost(gameScene, gameField);
               ghostRED.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostPINK.moveGhost(gameScene, gameField);
               ghostPINK.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostBLUE.moveGhost(gameScene, gameField);
               ghostBLUE.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostGREEN.moveGhost(gameScene, gameField);
               ghostGREEN.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostYELLOW.moveGhost(gameScene, gameField);
               ghostYELLOW.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               ghostPURPLE.moveGhost(gameScene, gameField);
               ghostPURPLE.checkIfGhostOverlapsPacman(pacman, soundPlayer);
               
               exitIfPacmanIsDeath(primaryStage, this);

               
               //clearing the canvas and drawing the updated GameField and Sprite Positions     
               renderScoreboard(scoreboardContext, scoreboardCanvas);
               gameFieldContext.setFill(Color.BLACK);
               gameFieldContext.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
               gameFieldContext.setFill(Color.BLACK);
               gameFieldContext.fillRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
               
               gameField.drawMaze(gameFieldContext);
               pacman.render(gameFieldContext);
               ghostRED.render(gameFieldContext);
               ghostPINK.render(gameFieldContext);
               ghostBLUE.render(gameFieldContext);   
               ghostGREEN.render(gameFieldContext);
               ghostYELLOW.render(gameFieldContext);
               ghostPURPLE.render(gameFieldContext);
            }

        };

        gameloop.start();
    }
}

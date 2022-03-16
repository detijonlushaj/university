package gameObjects.gameControllers;

import gameObjects.gameEngine.GameObject;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.input.*;
import menuObjects.MainMenuControllerNew;

import java.util.ArrayList;
/**
 * GameController for the first level
 * This level only use the Enemy type two
 * */
public class GameControllerLevel1 {
    int totalTime = 0;
    int score = 0;
    int life = 3;
    boolean pauseMenu = false;
    double enemySpeed;
    String enemyTwo = "/gameObjects/GameRessources/Gegner2_cuted.png";

    String easterEgg = "";

    //Methode to start the game
    public void gameStart(Stage stage, int diff) {
        enemySpeed = EnemySpeedController.enemySpeed(diff);

        stage.setTitle("Hacker Gradius");
        stage.setResizable(false);
        BorderPane root = new BorderPane();
        Scene mainScene = new Scene(root,1000,600);
        stage.setScene(mainScene);

        Canvas canvas = new Canvas(1000,600);
        GraphicsContext context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        ArrayList<String> keyPressedList = new ArrayList<String>();

        ArrayList<String> keyJustPressedList = new ArrayList<String>();

        //Keys which reacts on pressing
        mainScene.setOnKeyPressed(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    if(!keyPressedList.contains(keyName)){
                        keyPressedList.add(keyName);
                        keyJustPressedList.add(keyName);
                    }
                }
        );

        //Keys which reacts releasing of the key
        mainScene.setOnKeyReleased(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    if(keyPressedList.contains(keyName)){
                        keyPressedList.remove(keyName);
                    }
                }
        );

        MainMenuControllerNew mmcn = new MainMenuControllerNew();
        GameControllerLevel1 gc1 = new GameControllerLevel1();

        //Sound objects
        Sound playerLaser = new Sound("/gameObjects/GameRessources/laserShoot.wav",0.05);
        Sound explosionPlayer = new Sound("/gameObjects/GameRessources/explosionPlayer.wav",0.05);
        Sound pause = new Sound("/gameObjects/GameRessources/pause.wav",0.05);
        Sound explosionEnemyTwo = new Sound("/gameObjects/GameRessources/explosionEnemyTwo.wav",0.05);
        Sound losingSound = new Sound("/gameObjects/GameRessources/loseSound.wav",0.05);
        Sound winnigSound = new Sound("/gameObjects/GameRessources/winnigSound.wav",0.05);

        //GameObjects
        GameObject background = new GameObject("/gameObjects/GameRessources/Background_Game.gif");
        background.position.set(400,300);

        GameObject player = new GameObject("/gameObjects/GameRessources/Spieler1_cuted.png");
        player.position.set(100,300);

        //Arraylists with GameObjects
        ArrayList<GameObject> laserList = new ArrayList<GameObject>();
        ArrayList<GameObject> enemyTwoList = new ArrayList<GameObject>();


        //GameLoop(Here to add something for the game)
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player.velocity.set(0,0);
                //moving left
                if(keyPressedList.contains("A")){
                    if(player.getPosition().x > 50) {
                        player.velocity.add(-250, 0);
                    }
                }
                //moving right
                if(keyPressedList.contains("D")){
                    if(player.getPosition().x < 950) {
                        player.velocity.add(250, 0);
                    }
                }
                //moving down
                if(keyPressedList.contains("S")){
                    if(player.getPosition().y < 575) {
                        player.velocity.add(0, 200);
                    }
                }
                //moving up
                if(keyPressedList.contains("W")){
                    if(player.getPosition().y > 25) {
                        player.velocity.add(0, -200);
                    }
                }
                //shooting
                if(keyJustPressedList.contains("SPACE")) {
                    playerLaser.getSound().play();
                    GameObject laser = new GameObject("/gameObjects/GameRessources/Spieler_Schuss_cuted.png");
                    laser.position.set(player.position.x, player.position.y);
                    laser.velocity.add(200,0);
                    laser.velocity.setAngle(player.rotation);
                    laserList.add(laser);
                }
                //Return to main menu
                if(keyJustPressedList.contains("ESCAPE")) {
                    this.stop();
                    mmcn.initMenu(stage,"HackerGradius");
                }
                //pause the game
                if(keyJustPressedList.contains("P")) {
                    pause.getSound().play();
                    pauseMenu = !pauseMenu;
                }
                //restarts the game
                if(keyJustPressedList.contains("R")) {
                    this.stop();
                    gc1.gameStart(stage, diff);
                }

                //easterEgg - input
                if(keyJustPressedList.contains("H")){
                    easterEgg += "h";
                }
                if(keyJustPressedList.contains("S")){
                    easterEgg += "s";
                }

                keyJustPressedList.clear();

                if(!pauseMenu) {
                    stage.setTitle("HackerGradius");
                    //Player update
                    player.update(1/60.0);
                    //Laser update
                    for(GameObject laser: laserList) {
                        laser.update(1/60.0);
                    }
                    //Laser despawn update
                    for (int n = 0; n < laserList.size(); n++) {
                        GameObject laser = laserList.get(n);
                        laser.update(1/60.0);
                        if(laser.elapseTime > 6) {
                            laserList.remove(n);
                        }
                    }
                    //Enemy Update
                    for(GameObject enemy: enemyTwoList) {
                        enemy.update(1/60.0);
                    }
                    //Enemy despawn update
                    for (int n = 0; n < enemyTwoList.size(); n++) {
                        GameObject enemy = enemyTwoList.get(n);
                        enemy.update(1/60.0);
                        if(enemy.elapseTime > 50) {
                            enemyTwoList.remove(enemy);
                        }
                    }
                    //Enemy creator
                    if(totalTime % 50 == 0) {
                        GameObject enemy3 = new GameObject(enemyTwo);
                        double x = 1100;
                        double y = 800 * Math.random() + 50;
                        enemy3.position.set(x,y);
                        enemy3.velocity.set(enemySpeed,0);
                        enemyTwoList.add(enemy3);
                    }
                } else {
                    stage.setTitle("Pause");
                }
                //Background render
                background.render(context);
                //Player render
                player.render(context);
                //Laser render
                for(GameObject laser: laserList) {
                    laser.render(context);
                }
                //when a laser hits an enemy
                for(int laserNum = 0; laserNum < laserList.size(); laserNum++) {
                    GameObject laser = laserList.get(laserNum);
                    for(int enemyNum = 0; enemyNum < enemyTwoList.size(); enemyNum++) {
                        GameObject enemy = enemyTwoList.get(enemyNum);
                        if(laser.overlaps(enemy)) {
                            explosionEnemyTwo.getSound().play();
                            laserList.remove(laserNum);
                            enemyTwoList.remove((enemyNum));
                            score += 50;
                        }
                    }
                }
                //when an enemy hits the player
                for(int enemyNum = 0; enemyNum < enemyTwoList.size(); enemyNum++) {
                    GameObject enemy = enemyTwoList.get(enemyNum);
                    if (enemy.overlaps(player)) {
                        enemyTwoList.remove((enemyNum));
                        if(life > 1) {
                            explosionPlayer.getSound().play();
                            life -= 1;
                        } else {
                            losingSound.getSound().play();
                            this.stop();
                            mmcn.initMenu(stage,"YOU LOSE");
                        }
                    }
                }
                //Enemys render
                for(GameObject enemy: enemyTwoList) {
                    enemy.render(context);
                }
                //Score Label
                context.setFill(Color.WHITE);
                context.setStroke(Color.GREEN);
                context.setFont(new Font("Arial Black", 48));
                context.setLineWidth(3);
                String scoreText = "Score: " + score;
                int scoreTextX = 600;
                int scoreTextY = 80;
                context.fillText(scoreText, scoreTextX, scoreTextY);
                context.strokeText(scoreText, scoreTextX, scoreTextY);
                //Life Label
                context.setFill(Color.WHITE);
                context.setStroke(Color.RED);
                context.setFont(new Font("Arial Black", 48));
                context.setLineWidth(3);
                String lifeText = "Life: " + life;
                int lifeTextX = 50;
                int lifeTextY = 80;
                context.fillText(lifeText, lifeTextX, lifeTextY);
                context.strokeText(lifeText, lifeTextX, lifeTextY);
                //TotalTime for the enemy spawning
                totalTime += 1;
                //easterEgg
                if(easterEgg.equals("hsh")) {
                    enemyTwo = "/gameObjects/GameRessources/hsh_cuted.png";
                }
                //Winning condition
                if(score > 999) {
                    winnigSound.getSound().play();
                    this.stop();
                    mmcn.initMenu(stage,"YOU WON");
                }
            }
        };
        gameLoop.start();
        stage.show();
    }
}

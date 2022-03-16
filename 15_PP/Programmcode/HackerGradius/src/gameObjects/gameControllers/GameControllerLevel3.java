package gameObjects.gameControllers;

import gameObjects.gameEngine.GameObject;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import menuObjects.MainMenuControllerNew;

import java.util.ArrayList;
/**
 * GameController for the first level
 * This level only use the Enemy type one
 * */
public class GameControllerLevel3 {
    int totalTime = 0;
    int score = 0;
    int life = 3;
    boolean pauseMenu = false;
    double enemySpeed;
    double enemyLaserSpeed;
    String enemyOne = "/gameObjects/GameRessources/Gegner1_cuted.png";

    String easterEgg = "";

    //Methode to start the game
    public void gameStart(Stage stage, int diff) {
        enemySpeed = EnemySpeedController.enemySpeed(diff);
        enemyLaserSpeed = EnemySpeedController.enemyLaserSpeed(diff);

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
        GameControllerLevel3 gc3 = new GameControllerLevel3();

        //Sound objects
        Sound playerLaser = new Sound("/gameObjects/GameRessources/laserShoot.wav",0.05);
        Sound explosionPlayer = new Sound("/gameObjects/GameRessources/explosionPlayer.wav",0.05);
        Sound pause = new Sound("/gameObjects/GameRessources/pause.wav",0.05);
        Sound explosionEnemyOne = new Sound("/gameObjects/GameRessources/explosionEnemyOne.wav",0.05);
        Sound losingSound = new Sound("/gameObjects/GameRessources/loseSound.wav",0.05);
        Sound winnigSound = new Sound("/gameObjects/GameRessources/winnigSound.wav",0.05);

        //GameObjects
        GameObject background = new GameObject("/gameObjects/GameRessources/Background_Game.gif");
        background.position.set(400,300);

        GameObject player = new GameObject("/gameObjects/GameRessources/Spieler3_cuted.png");
        player.position.set(100,300);


        //Arraylists with GameObjects
        ArrayList<GameObject> laserList = new ArrayList<GameObject>();
        ArrayList<GameObject> enemyList = new ArrayList<GameObject>();
        ArrayList<GameObject> enemyLaserList = new ArrayList<GameObject>();

        //GameLoop(Here to add something for the game
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
                    gc3.gameStart(stage, diff);
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
                    //Laser despawn
                    for (int n = 0; n < laserList.size(); n++) {
                        GameObject laser = laserList.get(n);
                        laser.update(1/60.0);
                        if(laser.elapseTime > 6) {
                            laserList.remove(n);
                        }
                    }
                    //Enemy update
                    for(GameObject enemy: enemyList) {
                        enemy.update(1/60.0);
                    }
                    //Enemy laser
                    if(totalTime % 200 == 0) {
                        for (int n = 0; n < enemyList.size(); n++) {
                            GameObject enemylaser = new GameObject("/gameObjects/GameRessources/Gegner1_Schuss_cuted.png");
                            enemylaser.position.set(enemyList.get(n).position.x, enemyList.get(n).position.y);
                            enemylaser.velocity.set(enemyLaserSpeed, 0);

                            enemyLaserList.add(enemylaser);
                        }
                    }
                    //Enemy laser update
                    for(GameObject enemyLaser: enemyLaserList) {
                        enemyLaser.update(1/60.0);
                    }
                    //Enemy Spawner
                    if(totalTime % 50 == 0) {
                        GameObject enemy = new GameObject(enemyOne);
                        double x = 1100;
                        double y = 600 * Math.random() + 8;
                        enemy.position.set(x,y);
                        enemy.velocity.set(enemySpeed,0);
                        enemyList.add(enemy);

                    }
                    //Enemy despawner
                    for (int n = 0; n < enemyList.size(); n++) {
                        GameObject enemy = enemyList.get(n);
                        enemy.update(1/60.0);
                        if(enemy.elapseTime > 25) {
                            enemyList.remove(enemy);
                        }
                    }
                } else {
                    stage.setTitle("Pause");
                }
                //background rendering
                background.render(context);

                //Player rendering
                player.render(context);
                //Laser rendering
                for(GameObject laser: laserList) {
                    laser.render(context);
                }


                //when a laser hits an enemy
                for(int laserNum = 0; laserNum < laserList.size(); laserNum++) {
                    GameObject laser = laserList.get(laserNum);
                    for(int enemyNum = 0; enemyNum < enemyList.size(); enemyNum++) {
                        GameObject enemy = enemyList.get(enemyNum);
                        if(laser.overlaps(enemy)) {
                            explosionEnemyOne.getSound().play();
                            laserList.remove(laserNum);
                            enemyList.remove((enemyNum));
                            score += 50;
                        }
                    }
                }

                //when an enemy hits the player
                for(int enemyNum = 0; enemyNum < enemyList.size(); enemyNum++) {
                    GameObject enemy = enemyList.get(enemyNum);
                    if (enemy.overlaps(player)) {
                        enemyList.remove((enemyNum));
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

                //when an enemyLaser hits the player
                for(int laserNum = 0; laserNum < enemyLaserList.size(); laserNum++) {
                    GameObject enemyLaser = enemyLaserList.get(laserNum);
                    if(enemyLaser.overlaps(player)) {
                        enemyLaserList.remove(laserNum);
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

                //enemy rendering
                for(GameObject enemy: enemyList) {
                    enemy.render(context);
                }
                //enemy laser rendering
                for(GameObject enemyLaser: enemyLaserList) {
                    enemyLaser.render(context);
                }

                //Score display
                context.setFill(Color.WHITE);
                context.setStroke(Color.GREEN);
                context.setFont(new Font("Arial Black", 48));
                context.setLineWidth(3);
                String scoreText = "Score: " + score;
                int scoreTextX = 600;
                int scoreTextY = 80;
                context.fillText(scoreText, scoreTextX, scoreTextY);
                context.strokeText(scoreText, scoreTextX, scoreTextY);

                //Life display
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
                    enemyOne = "/gameObjects/GameRessources/hsh_cuted.png";
                }

                //Winning condition
                if(score > 4999) {
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

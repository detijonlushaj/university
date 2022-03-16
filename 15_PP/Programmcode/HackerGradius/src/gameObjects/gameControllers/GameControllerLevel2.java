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
 * This level use the Enemy type one and two
 * */
public class GameControllerLevel2 {
    int totalTime = 0;
    int score = 0;
    int life = 3;
    boolean pauseMenu = false;
    double enemySpeed;
    double enemyLaserSpeed;
    String enemyOne = "/gameObjects/GameRessources/Gegner1_cuted.png";
    String enemyTwo = "/gameObjects/GameRessources/Gegner2_cuted.png";

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
        GameControllerLevel2 gc2 = new GameControllerLevel2();

        //Sound objects
        Sound playerLaser = new Sound("/gameObjects/GameRessources/laserShoot.wav",0.05);
        Sound explosionPlayer = new Sound("/gameObjects/GameRessources/explosionPlayer.wav",0.05);
        Sound pause = new Sound("/gameObjects/GameRessources/pause.wav",0.05);
        Sound explosionEnemyOne = new Sound("/gameObjects/GameRessources/explosionEnemyOne.wav",0.05);
        Sound explosionEnemyTwo = new Sound("/gameObjects/GameRessources/explosionEnemyTwo.wav",0.05);
        Sound losingSound = new Sound("/gameObjects/GameRessources/loseSound.wav",0.05);
        Sound winnigSound = new Sound("/gameObjects/GameRessources/winnigSound.wav",0.05);

        //GameObjects
        GameObject background = new GameObject("/gameObjects/GameRessources/Background_Game.gif");
        background.position.set(400,300);

        GameObject player = new GameObject("/gameObjects/GameRessources/Spieler2_cuted.png");
        player.position.set(100,300);


        //Arraylists with GameObjects
        ArrayList<GameObject> laserList = new ArrayList<GameObject>();
        ArrayList<GameObject> enemyList = new ArrayList<GameObject>();
        ArrayList<GameObject> enemyLaserList = new ArrayList<GameObject>();
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
                    gc2.gameStart(stage, diff);
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
                    //player update
                    player.update(1/60.0);
                    //Laser update
                    for(GameObject laser: laserList) {
                        laser.update(1/60.0);
                    }
                    //Laser despawner
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
                    //Enemy shooting
                    if(totalTime % 200 == 0) {
                        for (int n = 0; n < enemyList.size(); n++) {
                            GameObject enemylaser = new GameObject("/gameObjects/GameRessources/Gegner1_Schuss_cuted.png");
                            enemylaser.position.set(enemyList.get(n).position.x, enemyList.get(n).position.y);
                            enemylaser.velocity.set(enemyLaserSpeed, 0);

                            enemyLaserList.add(enemylaser);
                        }
                    }
                    //EnemyLaser update
                    for(GameObject enemyLaser: enemyLaserList) {
                        enemyLaser.update(1/60.0);
                    }
                    //EnemyLaser despawner
                    for (int n = 0; n < enemyLaserList.size(); n++) {
                        GameObject enemyLaser = enemyLaserList.get(n);
                        enemyLaser.update(1/60.0);
                        if(enemyLaser.elapseTime > 20) {
                            enemyLaserList.remove(n);
                        }
                    }
                    //Enemy spawner
                    if(totalTime % 200 == 0) {
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
                        if(enemy.elapseTime > 50) {
                            enemyList.remove(enemy);
                        }
                    }
                    //EnemyTwo update
                    for(GameObject enemyTwo: enemyTwoList) {
                        enemyTwo.update(1/60.0);
                    }
                    //EnemyTwo spawner
                    if(totalTime % 100 == 0) {
                        GameObject enemy2 = new GameObject(enemyTwo);
                        double x = 1100;
                        double y = 600 * Math.random() + 8;
                        enemy2.position.set(x,y);
                        enemy2.velocity.set(enemySpeed,0);
                        enemyTwoList.add(enemy2);
                    }
                    //EnemyTwo despawner
                    for (int n = 0; n < enemyTwoList.size(); n++) {
                        GameObject enemy = enemyTwoList.get(n);
                        enemy.update(1/60.0);
                        if(enemy.elapseTime > 50) {
                            enemyTwoList.remove(enemy);
                        }
                    }

                } else {
                    stage.setTitle("Pause");
                }
                //background rendering
                background.render(context);
                //player rendering
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
                            playerLaser.getSound().play();
                            laserList.remove(laserNum);
                            enemyList.remove((enemyNum));
                            score += 50;
                        }
                    }
                }

                //when a laser hits an enemytwo
                for(int laserNum = 0; laserNum < laserList.size(); laserNum++) {
                    GameObject laser = laserList.get(laserNum);
                    for(int enemy2Num = 0; enemy2Num < enemyTwoList.size(); enemy2Num++) {
                        GameObject enemy2 = enemyTwoList.get(enemy2Num);
                        if(laser.overlaps(enemy2)) {
                            explosionEnemyTwo.getSound().play();
                            laserList.remove(laserNum);
                            enemyTwoList.remove((enemy2Num));
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

                //when an enemyTwo hits the player
                for(int enemyNum = 0; enemyNum < enemyTwoList.size(); enemyNum++) {
                    GameObject enemy2 = enemyTwoList.get(enemyNum);
                    if (enemy2.overlaps(player)) {
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

                //when an enemylaser hits the player
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
                //enemyLaser rendering
                for(GameObject enemyLaser: enemyLaserList) {
                    enemyLaser.render(context);
                }
                //enemyTwo rendering
                for(GameObject enemyTwo: enemyTwoList) {
                    enemyTwo.render(context);
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
                    enemyTwo = "/gameObjects/GameRessources/hsh_cuted.png";
                }
                //Winning condition
                if(score > 2499) {
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

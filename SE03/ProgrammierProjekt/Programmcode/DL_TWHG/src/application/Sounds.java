package application;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * sound effects class
 * @author lushaj
 *
 */
public class Sounds {
    private static String path_enemysound = "src/lushaj_res/enemyhit.wav";
    private static Media musicEnemyHit = new Media(new File(path_enemysound).toURI().toString());
    private static MediaPlayer mediaplayer_enemysound = new MediaPlayer(musicEnemyHit);
//    
//    String path_enemysound = getClass().getResource("src/lushaj_res/enemyhit.wav").toExternalForm();
//    MediaPlayer mediaplayer_enemysound = new MediaPlayer(new Media(path_enemysound));
    
    private static String path_check = "src/lushaj_res/checksound.wav";
    private static Media music_Check = new Media(new File(path_check).toURI().toString());
    private static MediaPlayer mediaplayer_check = new MediaPlayer(music_Check);
    
    private static String path_coin = "src/lushaj_res/coin.wav";
    private static Media music_coin = new Media(new File(path_coin).toURI().toString());
    private static MediaPlayer mediaplayer_coin = new MediaPlayer(music_coin);
    
    /**
     * create a sound effect if the player was hit by the enemy
     */
    public static void enemyhit() {
        mediaplayer_enemysound.setVolume(0.05);
        mediaplayer_enemysound.play();
    }
    /**
     * reset the sound effect
     */
    public static void reset_e_Sounds() {
        mediaplayer_enemysound.stop();
    }
    /**
     * create a Soundeffect if the User uses the Buttons or the Player enter the final Position
     */
    public static void check() {
        mediaplayer_check.setVolume(0.5);
        mediaplayer_check.play();
    }
    /**
     * reset the sound effect
     */
    public static void reset_check() {
        mediaplayer_check.stop();
    }
    /**
     * creates a sound if the Player collected a coin
     */
    public static void coin() {
        mediaplayer_coin.setVolume(0.05);
        mediaplayer_coin.play();
    }
    /**
     * reset the sound effect
     */
    public static void reset_coin() {
        mediaplayer_coin.stop();
    }
    
    
}

package application;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
	
    private static String path_eat = "src/Fugy_res/Eat.wav";
    private static Media music_eat = new Media(new File(path_eat).toURI().toString());
    private static MediaPlayer mediaplayer_coin = new MediaPlayer(music_eat);
    
    private static String path_start = "src/Fugy_res/Start.wav";
    private static Media music_start = new Media(new File(path_start).toURI().toString());
    private static MediaPlayer mediaplayer_start = new MediaPlayer(music_start);
    
    /**
     * creates a sound if the Player collects a token
     */
    public static void eat() {
        mediaplayer_coin.setVolume(0.05);
        mediaplayer_coin.play();
    }
    /**
     * reset the sound effect
     */
    public static void reset_eat() {
        mediaplayer_coin.stop();
    }
    
    /**
     * creates a sound if the Player starts the game
     */
    public static void startB() {
        mediaplayer_start.setVolume(0.5);
        mediaplayer_start.play();
    }
    /**
     * reset the sound effect
     */
    public static void reset_startB() {
        mediaplayer_start.stop();
    }
    
    
    
}

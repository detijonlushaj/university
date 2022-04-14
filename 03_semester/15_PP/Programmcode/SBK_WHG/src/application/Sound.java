//package application;
//
//public class Sound {
//    
//}

package application;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * 
 * @author Schehat
 * sound management
 */
public class Sound {
    private static Media mButtonClicked = new Media(new File("src/buttonClicked.mp3").toURI().toString());
    private static MediaPlayer mPButtonClicked = new MediaPlayer(mButtonClicked);
    private static Media mPunch = new Media(new File("src/punch.mp3").toURI().toString());
    private static MediaPlayer mPPunch = new MediaPlayer(mPunch);
    private static Media mCollect = new Media(new File("src/collect.mp3").toURI().toString());
    private static MediaPlayer mPCollect = new MediaPlayer(mCollect);
    private static Media mSuccess = new Media(new File("src/success.mp3").toURI().toString());
    private static MediaPlayer mPSuccess = new MediaPlayer(mSuccess);
    
    /**
     * play button clicked sound
     */
    public static void mPButtonClickedPlay() {
        mPButtonClicked.setVolume(0.3);
        mPButtonClicked.play();
    }
    
    /**
     * stop button clicked sound
     */
    public static void mPButtonClickedStop() {
        mPButtonClicked.stop();
    }
    
    /**
     * play punch sound which happens when player was hit by an enemy
     */
    public static void mPPunshPlay() {
        mPPunch.setVolume(0.3);
        mPPunch.play();
    }
    
    /**
     * stop punch sound
     */
    public static void mPPunshStop() {
        mPPunch.stop();
    }
    
    /**
     * play collect sound which happens when player collects a yellow circle
     */
    public static void mPCollectPlay() {
        mPCollect.setVolume(0.3);
        mPCollect.play();
    }
    
    /**
     * stop collect sound
     */
    public static void mPCollectStop() {
        mPCollect.stop();
    }
    
    /**
     * play success sound which happens when player reaches the goal (red square)
     * and collected all yellow circle
     */
    public static void mPSuccessPlay() {
        mPSuccess.setVolume(0.3);
        mPSuccess.play();
    }
    
    /**
     * stop success sound
     */
    public static void mPSuccessStop() {
        mPSuccess.stop();
    }
}

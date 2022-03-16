package gamelogic;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


/**
 * sound effects class
 * @author alend
 *
 */
public class SoundPlayer {
    
    private  MediaPlayer mediaplayer_lostHeartSound;
    private  MediaPlayer mediaplayer_lvlUpSound;
    private  MediaPlayer mediaplayer_rickrollsong;
    
    
    
    
    
    public void loadSounds() {
        String lostHeartURL = getClass().getResource("sounds/lostHeart.mp3").toExternalForm();
        String lvlUpURL = getClass().getResource("sounds/LVLUP.mp3").toExternalForm();
        String rickrollsongURL = getClass().getResource("sounds/rickrollsong.mp3").toExternalForm();
       
        mediaplayer_lostHeartSound = new MediaPlayer(new Media(lostHeartURL));
        mediaplayer_lvlUpSound = new MediaPlayer(new Media(lvlUpURL));
        mediaplayer_rickrollsong = new MediaPlayer(new Media(rickrollsongURL));
    }
    
    public void lostHeartSound() {
        mediaplayer_lostHeartSound.setVolume(0.10);
        mediaplayer_lostHeartSound.play();
    }
    
    public void resetLostHeartSound() {
        mediaplayer_lostHeartSound.stop();
    }
    
    public void lvlUpSound() {
        mediaplayer_lvlUpSound.setVolume(0.10);
        mediaplayer_lvlUpSound.play();
    }
    
    public void resetLvltUptSound() {
        mediaplayer_lvlUpSound.stop();
    }
    
    public void finishSong() {
        mediaplayer_rickrollsong.setVolume(0.15);
        mediaplayer_rickrollsong.play();
    }
    
    public void resetFinishSong() {     
        mediaplayer_rickrollsong.stop();
    }
    

    
    
}
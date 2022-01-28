package Sounds;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * sound effects class
 * 
 *
 */
public class Sound {
    // SOUND FÜR BUTTONS
    private String buttonSoundPath;
    private MediaPlayer buttonSoundMediaPlayer;

    // SOUND FÜR SCORE
    private String scoreSoundPath ;
    private MediaPlayer scoreSoundMediaPlayer;

    private String backgroundSoundPath;
    private MediaPlayer backgroundSoundMediaPlayer;

    // SOUND FÜR Shot
    private String shotSoundPath;
    private MediaPlayer shotSoundMediaPlayer;

    // SOUND FÜR Explosion
    private String explosionSoundPath ;
    private MediaPlayer explosionSoundMediaPlayer ;

    public void loadSounds() {
//        if (eingabe.equals("buttonSound")) {        // SOUND FÜR BUTTONS

            buttonSoundPath = getClass().getResource("buttonSound.wav").toExternalForm();
            buttonSoundMediaPlayer = new MediaPlayer(new Media(buttonSoundPath));
//        } else if (eingabe.equals("scoreSound")) {            // SOUND FÜR SCORE

            scoreSoundPath = getClass().getResource("scoreSound.wav").toExternalForm();
            scoreSoundMediaPlayer = new MediaPlayer(new Media(scoreSoundPath));
//        } else if (eingabe.equals("backgroundSound")) {    // SOUND FÜR BUTTONS

            backgroundSoundPath = getClass().getResource("backgroundSound.wav").toExternalForm();
            backgroundSoundMediaPlayer = new MediaPlayer(new Media(backgroundSoundPath));

//        } else if (eingabe.equals("shotSound")) {    // SOUND FÜR Shot

            shotSoundPath = getClass().getResource("shotSound.wav").toExternalForm();
            shotSoundMediaPlayer = new MediaPlayer(new Media(shotSoundPath));
//        } else if (eingabe.equals("explosionSound")) {    // SOUND FÜR Explosion

            explosionSoundPath = getClass().getResource("explosionSound.wav").toExternalForm();
            explosionSoundMediaPlayer = new MediaPlayer(new Media(explosionSoundPath));

//        }

    }

    // Stop steht für reset
    /* Sound Methoden für Buttons */
    public void buttonSoundStart() {
        buttonSoundMediaPlayer.setVolume(0.2);
        buttonSoundMediaPlayer.play();
    }

    public void buttonSoundStop() {
        buttonSoundMediaPlayer.stop();
    }

    /* Sound Methoden für Score */
    public void scoreSoundStart() {
        scoreSoundMediaPlayer.setVolume(0.2);
        scoreSoundMediaPlayer.play();
    }

    public void scoreSoundStop() {
        scoreSoundMediaPlayer.stop();
    }

    /* Sound Methoden für Explosion */
    public void explosionSoundStart() {
        explosionSoundMediaPlayer.setVolume(0.2);
        explosionSoundMediaPlayer.play();
    }

    public void explosionSoundStop() {
        explosionSoundMediaPlayer.stop();
    }

    /* Sound Methoden für Shot */
    public void shotSoundStart() {
        shotSoundMediaPlayer.setVolume(0.2);
        shotSoundMediaPlayer.play();
    }

    public void shotSoundStop() {
        shotSoundMediaPlayer.stop();
    }

    /* Sound Methoden für Background */
    public void backgroundStart() {
        backgroundSoundMediaPlayer.setVolume(0.2);
        backgroundSoundMediaPlayer.play();
    }

    public void backgroundStop() {
        backgroundSoundMediaPlayer.stop();
    }

}
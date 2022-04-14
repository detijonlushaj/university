package gameObjects.gameControllers;

import javafx.scene.media.AudioClip;
/**
 * creates the sound for an action
 * */
public class Sound {
    AudioClip sound;
    //constructor of the sound object
    public Sound (String path, double volume) {
        sound = new AudioClip(this.getClass().getResource(path).toString());
        sound.setVolume(volume);
    }
    //getter for the sound object
    public AudioClip getSound() {
        return sound;
    }
}
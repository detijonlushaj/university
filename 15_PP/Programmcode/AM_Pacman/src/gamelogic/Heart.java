package gamelogic;

import javafx.scene.image.Image;

public class Heart extends Sprite {
    private Image lostHeart;
    
    public void setLostHeartImage(String filename ) {
        this.lostHeart = new Image(filename);
        this.getBoundary().setWidth(lostHeart.getWidth());
        this.getBoundary().setHeight(lostHeart.getWidth());      
    }

    public Image getLostHeart() {
        return lostHeart;
    }

    public void setLostHeart(Image lostHeart) {
        this.lostHeart = lostHeart;
    }
    
    
}

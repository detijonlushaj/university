package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Schehat
 * object controllable by the user
 */
public class Player {
    private Image iPlayer;
    private ImageView iVPlayer;
    
    /**
     * create player character
     */
    Player(String name) {
        iPlayer = new Image(name + ".png");
        iVPlayer = new ImageView(iPlayer);
    }
    
    /**
     * 
     * @param x location
     */
    public void setX(double x) {
        iVPlayer.setX(x);
    }
    
    /**
     * 
     * @param y location 
     */
    public void setY(double y) {
        iVPlayer.setY(y);
    }
    
    /**
     * 
     * @return x location of player
     */
    public double getX() {
        return iVPlayer.getX();
    }
    
    /**
     * 
     * @return y location of player
     */
    public double getY() {
        return iVPlayer.getY();
    }
   
    /**
     * 
     * @return imageView of player object
     */
    public ImageView getImageView() {
        return iVPlayer;
    }
    
    /**
     * 
     * @return image of player object
     */
    public Image getImage() {
        return iPlayer;
    }
}

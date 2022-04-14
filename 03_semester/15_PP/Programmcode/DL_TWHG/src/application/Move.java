package application;

import javafx.scene.image.ImageView;
/**
 * ImageView movement class
 * @author lushaj
 *
 */
public class Move {
    /**
     *  Let the Player move to this direction
     */
    public static void moveX(ImageView iv_Player,double speed) {
        iv_Player.setX(iv_Player.getX() + speed);
    }
    /**
     *  Let the Player move to this direction
     */
    public static void moveY(ImageView iv_Player,double speed) {
        iv_Player.setY(iv_Player.getY() + speed);
    }    
}

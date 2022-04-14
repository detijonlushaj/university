package application;

/**
 * 
 * @author Schehat
 * controls of the game the user can use
 */
public class Controller {
    private static double speed = 1.5;
    
    /**
     * decrements x location
     * @param player
     */
    public static void moveLeft(Player player) {
        player.setX(player.getX() - speed);
    }
    
    /**
     * increments x location
     * @param player
     */
    public static void moveRight(Player player) {
        player.setX(player.getX() + speed);
    }
    
    /**
     * decrements y location
     * @param player
     */
    public static void moveUp(Player player) {
        player.setY(player.getY() - speed);
    }
    
    /**
     * increments y location
     * @param player
     */
    public static void moveDown(Player player) {
        player.setY(player.getY() + speed);
    }
    
    /**
     * 
     * @return movement speed
     */
    public static double getSpeed() {
        return speed;
    }
}

package gameObjects.gameControllers;
/**
 * Setts the speed of the enemy and the enemy laser
 * */
public class EnemySpeedController {
    //sets the enemy speed
    public static double enemySpeed(int diff) {
        double result;
        switch (diff) {
            case 1:
                result = -25;
                break;
            case 2:
                result = -50;
                break;
            case 3:
                result = -75;
                break;
            default:
                System.out.println("Error 404");
                result = 0;
        }
        return result;
    }

    //sets the enemy laser speed
    public static double enemyLaserSpeed(int diff) {
        double result;
        switch (diff) {
            case 1:
                result = -100;
                break;
            case 2:
                result = -150;
                break;
            case 3:
                result = -200;
                break;
            default:
                System.out.println("Error 404");
                result = 0;
        }
        return result;
    }
}

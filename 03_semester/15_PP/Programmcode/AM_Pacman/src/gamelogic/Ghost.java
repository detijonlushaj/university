package gamelogic;

import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.Scene;

public class Ghost extends Sprite {
    public final String level1 = "level1";
    public final String level1Extra = "level1extra";
    public final String level2 = "level2";
    public final String level2Extra = "level2extra";

    public final String MOVEUP = "moveUP";
    public final String MOVEDOWN = "moveDOWN";
    public final String MOVELEFT = "moveLEFT";
    public final String MOVERIGHT = "moveRIGHT";

    private double ghostSpeed = 2;
    private String ghostDifficulty;
    private String direction;
    private String[] directions = { MOVEUP, MOVEDOWN, MOVELEFT, MOVERIGHT };

    public void moveGhost(Scene gameScene, GameField gameField) {
        int pos;
        short ch;
        if (this.getPosition().getX() % gameField.getBLOCK_SIZE() == 0
                && this.getPosition().getY() % gameField.getBLOCK_SIZE() == 0) {
            if (ghostDifficulty.equals(level1Extra) || ghostDifficulty.equals(level2Extra)) {
                this.changeDirection();
                this.getVelocity().set(this.getReq_dx(), this.getReq_dy());

            } else {
                this.getVelocity().set(this.getReq_dx(), this.getReq_dy());
            }
            pos = (int) (this.getPosition().getX() / gameField.getBLOCK_SIZE()
                    + gameField.getN_BLOCKS() * (int) (this.getPosition().getY() / gameField.getBLOCK_SIZE()));
            ch = (short) gameField.getScreenData(pos);

            // Check Walls, if true change direction
            while (this.checkIfWall(ch)) {
                this.getVelocity().set(0, 0);
                changeDirection();
            }

        }
        this.getPosition().add(this.getVelocity().getX() * this.ghostSpeed,
                this.getVelocity().getY() * this.ghostSpeed);
    }

    public double getGhostSpeed() {
        return ghostSpeed;
    }

    public void setGhostSpeed(double ghostSpeed) {
        this.ghostSpeed = ghostSpeed;
    }

    public void setStartDirection(String direction) {
        if (direction.equals("moveUP")) {
            this.setReq_dx(0);
            this.setReq_dy(-1);
        }
        if (direction.equals("moveDOWN")) {
            this.setReq_dx(0);
            this.setReq_dy(1);
        }
        if (direction.equals("moveLEFT")) {
            this.setReq_dx(-1);
            this.setReq_dy(0);
        }
        if (direction.equals("moveRIGHT")) {
            this.setReq_dx(1);
            this.setReq_dy(0);
        }
    }

    public void checkIfGhostOverlapsPacman(PacMan pacman, SoundPlayer soundPlayer) {
        if (pacman.getBoundary().overlaps(this.getBoundary())) {
            this.setPosition(200, 200);
            pacman.reduceLife(soundPlayer);
        }
    }

    public String getGhostDifficulty() {
        return ghostDifficulty;
    }

    public void setGhostDifficulty(String ghostDifficulty) {
        this.ghostDifficulty = ghostDifficulty;
    }

    private void changeDirection() {

        int random = ThreadLocalRandom.current().nextInt(0, 3 + 1);
        direction = directions[random];

        if (direction.equals("moveUP")) {
            this.setReq_dx(0);
            this.setReq_dy(-1);
        }
        if (direction.equals("moveDOWN")) {
            this.setReq_dx(0);
            this.setReq_dy(1);
        }
        if (direction.equals("moveLEFT")) {
            this.setReq_dx(-1);
            this.setReq_dy(0);
        }
        if (direction.equals("moveRIGHT")) {
            this.setReq_dx(1);
            this.setReq_dy(0);
        }
    }
}

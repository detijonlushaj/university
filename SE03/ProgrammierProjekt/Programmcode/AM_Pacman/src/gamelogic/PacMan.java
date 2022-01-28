package gamelogic;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

public class PacMan extends Sprite {
    private String[] validKeys = {"UP","W","DOWN", "S", "LEFT", "A", "RIGHT", "D"};
    private ArrayList<String> validKeyList = new ArrayList<>();
    private ArrayList<String> inputList = new ArrayList<>();
    private static int score = 0;
    private double pacmanSpeed = 2.5;
    private int life = 3;
    private String moveDownImg;
    private String moveUpImg;
    private String moveLeftImg;
    private String moveRightImg;
    
    
    public void setValidMovementKeys() {
        for(int i =  0; i < validKeys.length; i++){
            validKeyList.add(validKeys[i]);
       }
    }
    
    public void updateInteractionWithGameField(GameField gameField) {
        int pos;
        short ch;
        // only move in part of twentie pixels
        if ((int)this.getPosition().getX() % gameField.getBLOCK_SIZE() == 0 && (int)this.getPosition().getY() % gameField.getBLOCK_SIZE() == 0) {
            this.getVelocity().set(this.getReq_dx(),this.getReq_dy());
            pos = (int)(this.getPosition().getX() / gameField.getBLOCK_SIZE() + gameField.getN_BLOCKS() * (this.getPosition().getY() / gameField.getBLOCK_SIZE()));
            ch = (short) gameField.getScreenData(pos);
            
            /*
            System.out.println("x: " + this.getPosition().getX() + "\t y:" +this.getPosition().getY());
            System.out.println("pos :" + pos + "\t ch: "+ ch+"\n");
            */
            
            // collect a point
            if ((ch & 16) != 0) {
                gameField.setScreenData(pos, (short) (ch & 15));
                score++;
                //System.out.println(score);
            }
            
            // Check for Wall, if true standstill and set velocity to 0
            if (this.checkIfWall(ch)) {
                this.getVelocity().set(0,0);
            }
        }
        this.getPosition().add(this.getVelocity().getX()*this.pacmanSpeed, this.getVelocity().getY()*this.pacmanSpeed);
    }

    public void movePacMan(Scene gameScene, GameField gameField) {
        gameScene.setOnKeyPressed((KeyEvent event) -> {
            String keyName = event.getCode().toString();
            if (!inputList.contains(keyName) && validKeyList.contains(keyName)) {
                inputList.add(keyName);
            }
        });

        if(inputList.contains("UP") || inputList.contains("W")) {
            this.setImage(moveUpImg);
            this.setReq_dx(0);
            this.setReq_dy(-1);
        }
        if(inputList.contains("DOWN") || inputList.contains("S")) {
            this.setImage(moveDownImg);
            this.setReq_dx(0);
            this.setReq_dy(1);
        }
        if(inputList.contains("LEFT") || inputList.contains("A")) {
            this.setImage(moveLeftImg);
            this.setReq_dx(-1);
            this.setReq_dy(0);
        }
        if(inputList.contains("RIGHT") || inputList.contains("D")) {
            this.setImage(moveRightImg);
            this.setReq_dx(1);
            this.setReq_dy(0);
        }
        this.updateInteractionWithGameField(gameField);
        // remove input if another key is pressed
        if((inputList.size() > 1)) {
           inputList.remove(0);
        }     
    }
    
    public ArrayList<String> getInputList() {
        return inputList;
    }

    public void setInputList(ArrayList<String> inputList) {
        this.inputList = inputList;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int sc) {
        score = sc;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public void reduceLife(SoundPlayer soundPlayer) {
        this.life = this.life -1;
        soundPlayer.resetLostHeartSound();
        soundPlayer.lostHeartSound();
    }

    public String getMoveDownImg() {
        return moveDownImg;
    }

    public void setMoveDownImg(String moveDownImg) {
        this.moveDownImg = moveDownImg;
    }

    public String getMoveUpImg() {
        return moveUpImg;
    }

    public void setMoveUpImg(String moveUpImg) {
        this.moveUpImg = moveUpImg;
    }

    public String getMoveLeftImg() {
        return moveLeftImg;
    }

    public void setMoveLeftImg(String moveLeftImg) {
        this.moveLeftImg = moveLeftImg;
    }

    public String getMoveRightImg() {
        return moveRightImg;
    }

    public void setMoveRightImg(String moveRightImg) {
        this.moveRightImg = moveRightImg;
    }
    
}

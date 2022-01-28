package gamelogic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameField {
    private final int BLOCK_SIZE = 20;
    private final int N_BLOCKS = 20;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    private short[] screenData = new short[SCREEN_SIZE];
    private short[] levelData;
    
    // 22 = oben + rechts Wand
    // 19 = oben + links Wand
    // 28 = unten + rechts Wand
    // 25 = unten + links Wand
    // 21 = links + rechts Wand
    // 26 = oben + unten Wand
    // 18 = oben Wand
    // 24 = unten Wand
    // 20 = rechts Wand
    // 17 = links Wand
    // 16 = Punkt
    
    /*      LEERES LEVEL LAYOUT
                                                 //M
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // obere Mitte
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // Mitte
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20, // untere Mitte
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
                                                 //M
     */
    
    public void setLevelData(short[] levelData) {
        this.levelData = levelData;
    }

    public void drawMaze(GraphicsContext gameFieldContext) {
        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {
                
                gameFieldContext.setFill(Color.GREENYELLOW);
                
                if ((levelData[i] == 0)) { 
                    gameFieldContext.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                 }

                if ((screenData[i] & 1) != 0) { 
                    gameFieldContext.strokeLine(x, y, x, y + BLOCK_SIZE -1);
                }

                if ((screenData[i] & 2) != 0) { 
                    gameFieldContext.strokeLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    gameFieldContext.strokeLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    gameFieldContext.strokeLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    gameFieldContext.setFill(Color.ALICEBLUE);
                    gameFieldContext.fillOval(x + 10, y + 10, 6, 6);
               }

                i++;
            }
        }
    }
    
    public void initLevel() {

        int i;
        for (i = 0; i < N_BLOCKS * N_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }

    }

    public int getScreenData(int i) {
        return screenData[i];
    }

    public void setScreenData(int pos, short i) {
        this.screenData[pos] = i;
    }

    public int getBLOCK_SIZE() {
        return BLOCK_SIZE;
    }

    public int getN_BLOCKS() {
        return N_BLOCKS;
    }

    public int getSCREEN_SIZE() {
        return SCREEN_SIZE;
    }

    public short[] getLevelData() {
        return levelData;
    }
    
    
    
}

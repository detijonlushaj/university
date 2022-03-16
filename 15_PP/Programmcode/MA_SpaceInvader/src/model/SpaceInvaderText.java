package model;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SpaceInvaderText extends Text {

    public SpaceInvaderText(String text, int x, int y, int Size) {
        this.setText(text);
        this.setX(x);
        this.setY(y);
        this.setFill(Color.BLACK);
        this.setFont(Font.font("OCR A Extended", Size));

    }

}

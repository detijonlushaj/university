package menuObjects;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/**
 * Creats a button
 * */
public class createLabel {
    Label title;
    //constructor of the label
    public createLabel(String name, int g, int x, int y) {
        title= new Label(name);
        title.setTextFill(Color.PINK);
        title.setFont(Font.font("FontT", FontWeight.BOLD,g));
        title.setLayoutX(x);
        title.setLayoutY(y);
    }
    //getter of the label
    public Label getLabel() {
        return title;
    }
}

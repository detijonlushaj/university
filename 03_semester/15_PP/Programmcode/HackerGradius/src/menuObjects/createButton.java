package menuObjects;

import javafx.scene.control.Button;
/**
 * Creats a button
 * */
public class createButton {
    private Button button;
    // constructor of the object
    public createButton(String buttontext, double x, double y) {
        button = new Button (buttontext);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setStyle("-fx-font-size:25");
        button.setMinSize(120, 50);
    }
    //getter of the button
    public Button getButton() {
        return button;
    }
}

package menuObjects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Creats a background
 * */
public class createBackground {
    Image image;
    ImageView background;
    //constructor
    public createBackground(String imagePath) {
        image = new Image(imagePath);
        background = new ImageView(image);
    }
    //getter
    public ImageView getBackground() {
        return background;
    }
}

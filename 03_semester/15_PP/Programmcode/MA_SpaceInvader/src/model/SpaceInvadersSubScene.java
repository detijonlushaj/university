package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.util.Duration;

public class SpaceInvadersSubScene extends SubScene {
    private final static String BACKGROUND_IMAGE = "ProjecktPics/ViewElements/SpaceInvaderSubScene.png";
    private boolean sceneisHidden;

    /* Diese Konstruktor ist für die subscenen in dem ViewManager */
    public SpaceInvadersSubScene() {
        super(new AnchorPane(), 600, 600);
        prefWidth(600);
        prefHeight(600);
        this.setOpacity(0.6);
        Image background = new Image(BACKGROUND_IMAGE, 600, 600, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(backgroundImage));
        sceneisHidden = true;
        setLayoutX(950);
        setLayoutY(230);
    }

    /* Diese Konstruktor ist für die subscenen in dem GameViewManager */
    public SpaceInvadersSubScene(int level) {
        super(new AnchorPane(), 600, 600);
        prefWidth(600);
        prefHeight(600);
        this.setOpacity(0.6);
        ;
        Image background = new Image(BACKGROUND_IMAGE, 600, 600, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(backgroundImage));
        sceneisHidden = true;
        setLayoutX(150);
        setLayoutY(150);
    }

    /* DIESE METHODE BEWEGT MEINE SUBSCENE */
    public void moveSubScene() {
        // DIES IST WICHTIG FÜR DIE BEWEGUNG
        TranslateTransition transition = new TranslateTransition();
        // BEWEGUNG
        transition.setDuration(Duration.seconds(0.3));
        // DIESE METHODE ENTSCHEIDET WELCHES ELEMENT SICH BEWEGEN SOLL
        transition.setNode(this);
        // WIE EIN ELEMENT SICH AUF DIE X-ACHSE BEWEGT
        if (sceneisHidden) {
            transition.setToX(-660);
            sceneisHidden = false;
        } else {
            transition.setToX(0);
            sceneisHidden = true;
        }

        transition.play();
    }

    public AnchorPane getPane() {
        return (AnchorPane) this.getRoot();

    }

}

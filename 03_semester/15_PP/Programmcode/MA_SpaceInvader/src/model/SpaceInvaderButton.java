package model;

import Sounds.Sound;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

/*DIESE KLASSE EXTENDIET VON DEM BUTTON UND IST SO ANGEPASST DAMIT SIE DAS SPIEL STIEL ENTSPRICHT */

public class SpaceInvaderButton extends Button {
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image : url('ProjecktPics/ViewElements/green_button01.pr.png')";
    private final String BUTTON_RELEASED_STYLE = "-fx-background-color: transparent; -fx-background-image : url('ProjecktPics/ViewElements/green_button00.re.png')";
    private Sound sounds;

    /* HIER IST DER KONSTRUKTOR */
    public SpaceInvaderButton(String text) {
        sounds = new Sound();
        sounds.loadSounds();
        setText(text);
        setButtonFont();
        setPrefHeight(45);
        setPrefWidth(190);
        setStyle(BUTTON_RELEASED_STYLE);
        initializeButtonListeners();
    }

    /* HIER IST DER FONT VOM BUTTONS */
    private void setButtonFont() {
        setFont(Font.font("OCR A Extended", 30));
    }

    /*
     * DIESE METHODE SETZT DAS MODEL VOM GEPRESSTEN BUTTON (SIEHE
     * src\model\resources UM DAS BILD ZU ANGUCKEN)
     */
    private void SetButtonPressedPic() {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);
    }

    /*
     * DIESE METHODE SETZT DAS MODEL VOM RELEASED BUTTON (SIEHE src\model\resources
     * UM DAS BILD ZU ANGUCKEN)
     */
    private void SetButtonReleasedPic() {
        setStyle(BUTTON_RELEASED_STYLE);
        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }

    /* KeyListener und Sounds */
    private void initializeButtonListeners() {

        setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                sounds.buttonSoundStop();
                sounds.buttonSoundStart();

                // CHECK IF PRIMARY MOUSE BUTTON IS CLICKED
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    SetButtonPressedPic();

                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                // CHECK IF PRIMARY MOUSE BUTTON IS CLICKED
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    SetButtonReleasedPic();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });

    }

}

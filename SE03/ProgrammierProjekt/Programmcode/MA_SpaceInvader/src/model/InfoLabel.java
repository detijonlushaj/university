package model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;
/*DIESE KLASSE EXTENDIET VON DEM LABEL UND IST SO ANGEPASST DAMIT SIE DAS SPIEL STIEL ENTSPRICHT */ 
public class InfoLabel extends Label {
    private final static String InfoLabel_IMAGE = "ProjecktPics/ViewElements/infolabel.png";

    public InfoLabel(String text) {
        setInfoPref(text);

    }

    public InfoLabel(String eingabe, int score) {
        setScorePref(eingabe);
    }

    private void setBackground() {
        BackgroundImage backgeound = new BackgroundImage(new Image(InfoLabel_IMAGE, 380, 60, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgeound));

    }

    private void setLabelFont() {
        setFont(Font.font("OCR A Extended", 24));
    }

    public void setInfoPref(String text) {
        setPrefHeight(60);
        setPrefWidth(380);
        setAlignment(Pos.CENTER);
        setText(text);
        setWrapText(true);
        setLabelFont();
        setBackground();
    }

    public void setScorePref(String eingabe) {
        this.setText(eingabe);
//        this.setPrefHeight(49);
//        this.setPrefWidth(190);
//        this.setPadding(new Insets(10, 10, 10, 10));
        setLabelFont();
        setBackground();
    }

}

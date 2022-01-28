package gui;

import gamelogic.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class finishedGameGUI {
 public static void setStage(Stage primaryStage, SoundPlayer soundPlayer) {
        
        /* creates the Pane of the gamemenu*/
        StackPane helpMenu = new StackPane();
        helpMenu.setMaxSize(728, 336);
        
        // create an Image and and Imageview
        Image menuBackround = new Image(("res/images/menuBackround.jpg"));
        ImageView menuBackroundView = new ImageView(menuBackround);
        
        // create an Image and and Imageview
        Image rickrollImg = new Image(("res/images/rick-roll.gif"));
        ImageView rickrollImgBackroundView = new ImageView(rickrollImg);
        
        
        
        Label controllInformation2 = new Label();
        controllInformation2.setText("Congratulations!");
        controllInformation2.setTextFill(Color.web("#FFFFFF"));
        controllInformation2.setPrefSize(300, 100);
        controllInformation2.setFont(new Font("OCR A Extended", 20));
        
        // exits the helpMenu
        Button back = new Button();
        back.setText("Back to Menu");
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    soundPlayer.resetFinishSong();
                    GameMenuGUI.setStage(primaryStage);
            }
         });
        
        
        // adding the menuBackroundView + the buttons with the right position to the Pane
        helpMenu.getChildren().addAll(menuBackroundView);
        helpMenu.getChildren().addAll(rickrollImgBackroundView);
        StackPane.setAlignment(rickrollImgBackroundView, Pos.CENTER);
        helpMenu.getChildren().addAll(back,controllInformation2);
        StackPane.setAlignment(controllInformation2, Pos.TOP_CENTER);
        StackPane.setAlignment(back, Pos.BOTTOM_CENTER); 
        
       
        // setting the scene
        Scene helpMenuScene = new Scene(helpMenu);
        primaryStage.setScene(helpMenuScene);
    }
}

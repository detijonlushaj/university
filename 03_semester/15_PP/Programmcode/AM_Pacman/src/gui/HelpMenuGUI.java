package gui;

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

public class HelpMenuGUI {

    final double FONT_SIZE = 30.0;
    
    public static void setStage(Stage primaryStage) {
        
        /* creates the Pane of the gamemenu*/
        StackPane helpMenu = new StackPane();
        helpMenu.setMaxSize(728, 336);

        // create an Image and and Imageview
        Image menuBackround = new Image("res/images/menuBackround.jpg");
        ImageView menuBackroundView = new ImageView(menuBackround);
        
        
        Label controllInformation = new Label();
        controllInformation.setText("Move UP/DOWN/LEFT/RIGHT:");
        controllInformation.setTextFill(Color.web("#FFFFFF"));
        controllInformation.setPrefSize(300, 100);
        controllInformation.setFont(new Font("OCR A Extended", 20));
        
        Label controllInformation2 = new Label();
        controllInformation2.setText("W/ S / A /D    OR    ARROW-KEYS");
        controllInformation2.setTextFill(Color.web("#FFFFFF"));
        controllInformation2.setPrefSize(300, 100);
        controllInformation2.setFont(new Font("OCR A Extended", 20));
        
        // exits the helpMenu
        Button back = new Button();
        back.setText("Back");
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    GameMenuGUI.setStage(primaryStage);
            }
         });
        
        
        // adding the menuBackroundView + the buttons with the right position to the Pane
        helpMenu.getChildren().addAll(menuBackroundView);
        helpMenu.getChildren().addAll(back, controllInformation,controllInformation2);
        StackPane.setAlignment(controllInformation, Pos.TOP_CENTER);
        StackPane.setAlignment(back, Pos.BOTTOM_CENTER); 
        
       
        // setting the scene
        Scene helpMenuScene = new Scene(helpMenu);
        primaryStage.setScene(helpMenuScene);
    }
}
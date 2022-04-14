package gui;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameMenuGUI {

    public static void setStage(Stage primaryStage) {
        /* creates the Pane of the gamemenu*/
        StackPane root = new StackPane();
        root.setMaxSize(728, 336);
        
        // create an Image and and Imageview
        Image menuBackround = new Image("res/images/menuBackround.jpg");
        ImageView menuBackroundView = new ImageView(menuBackround);
       
        /*creating Buttons for the gameMenu*/
        // starts the game with the first level
        Button start = new Button();
        start.setText("Start");
        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    GameGUI gameGUI = new GameGUI();
                    gameGUI.setStage(primaryStage);
            }
         });
        
        // switches to a new scene where u can see the manuals of the game
        Button help = new Button();
        help.setText("Help");
        help.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    HelpMenuGUI.setStage(primaryStage);
            }
         });
        
        // exits the game
        Button exit = new Button();
        exit.setText("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    System.out.println("You've closed the Game!");
                    primaryStage.close();
            }
         });
        
        // adding the menuBackroundView + the buttons with the right position to the Pane
        root.getChildren().addAll(menuBackroundView);
        root.getChildren().addAll(start, help, exit);
        StackPane.setAlignment(start, Pos.TOP_CENTER); 
        StackPane.setAlignment(exit, Pos.BOTTOM_CENTER); 
        
        
        // setting the scene
        Scene menuScene = new Scene(root);
        primaryStage.setScene(menuScene);
    }

}
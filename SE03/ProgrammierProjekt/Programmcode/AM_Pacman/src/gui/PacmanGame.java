package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class PacmanGame extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setTitle("Matrix_Pacman");
        GameMenuGUI.setStage(primaryStage);
        primaryStage.show();
    }

}
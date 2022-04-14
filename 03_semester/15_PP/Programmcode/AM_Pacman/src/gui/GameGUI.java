package gui;


import gamelogic.Levels;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameGUI {

    public void setStage(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        root.setMaxSize(400, 450);
        Scene gameScene = new Scene(root);

        Canvas gameCanvas = new Canvas(400, 400);
        GraphicsContext gameFieldContext = gameCanvas.getGraphicsContext2D();

        Canvas scoreboardCanvas = new Canvas(400, 50);
        GraphicsContext scoreboardContext = scoreboardCanvas.getGraphicsContext2D();

        root.setCenter(gameCanvas);
        root.setBottom(scoreboardCanvas);



        /* ######## Game Code ######## */
        Levels.startGame(scoreboardCanvas, gameCanvas, gameFieldContext, scoreboardContext, gameScene, primaryStage);
        /* ######## End Of Game Code ######## */

        // setting the scene
        primaryStage.setScene(gameScene);
    }
}

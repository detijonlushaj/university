package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;



public class Main extends Application {
    private int count = 0;
    @Override
    public void start(Stage primaryStage) {
        Label lbl = new Label("0  Clicks");
        Button btnCalc = new Button("Click");
        HBox inp = new HBox();
        inp.getChildren().addAll(lbl, btnCalc);
        inp.setSpacing(5); //5px abstand zwischen den Elementen
        inp.setAlignment(Pos.BASELINE_LEFT);    //zentral schrift
        inp.setPadding(new Insets(5,10,5,10)); //Innenabstände im Uhrzeigersinn

        
        EventHandler<ActionEvent> handler= new EventHandler<ActionEvent>() {

            @Override public void handle(ActionEvent event) { 
                count ++;
                lbl.setText(count + " Clicks");
            }
        }; 
        btnCalc.setOnAction(handler);   //gibt andere Eventhaelnder
        btnCalc.setOnAction(event -> { 
            lbl.getScene().setCursor(Cursor.WAIT); //mauszeiger 
            Thread ht= new Thread( () -> {                      //new Thread
                for (long i=0; i<10_000_000_000L; i++) {};      
                count++;
                Platform.runLater( () -> {                      //1*
                    lbl.setText(count + " Clicks");
                    lbl.getScene().setCursor(Cursor.DEFAULT);
                });
            });
            ht.start(); 
        });

        Scene scene = new Scene(inp,130 , -1);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
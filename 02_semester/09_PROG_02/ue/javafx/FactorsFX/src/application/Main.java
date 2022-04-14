package application;

import javafx.application.Application;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;



public class Main extends Application {

    private TextField tfNumber;
    private Button btnCalc;
    EventHandler<ActionEvent> handler;
    Label lblStatus;

    @Override
    public void start(Stage primaryStage) {
        try {
            //Alternatives Layout: FlowPane statt HBox: dann verschiebt sich nichts !
            //FlowPane inp= new FlowPane(Orientation.HORIZONTAL);

            Label lbl = new Label("Number");
            tfNumber = new TextField();
            btnCalc = new Button("Calculate");
            btnCalc.setMnemonicParsing(true); //Alt+C zum ausfuehren

            HBox inp = new HBox();
            inp.getChildren().addAll(lbl, tfNumber, btnCalc);

            //Stylen
            inp.setSpacing(5); //5px abstand zwischen den Elementen
            inp.setAlignment(Pos.BASELINE_LEFT);    //zentral schrift
            inp.setPadding(new Insets(5,10,5,10)); //Innenabstände im Uhrzeigersinn
            //farbverlauf       vordefinierte farbssymbolde
            inp.setStyle("-fx-background-color:linear-gradient(to bottom,khaki,lavender);");
            HBox.setHgrow(tfNumber, Priority.ALWAYS);   //mitwachsen immer
            HBox.setHgrow(lbl, Priority.NEVER);         //mitwachsen nie
            HBox.setHgrow(btnCalc, Priority.NEVER);     //mitwachsen nie

            Label lblResult = new Label("Result: ");
            ScrollPane sp= new ScrollPane(lblResult); //man kann scrollen!!
            sp.setPrefSize(230, 70); //pref groesse (-1 -> min platz (-1,70)
            lblResult.setAlignment(Pos.TOP_LEFT);    //oben links zentieren

            lblStatus = new Label("");      //fuer den BottomText

            BorderPane bp = new BorderPane();   //anstatt root
            bp.setTop(inp);
            bp.setCenter(sp);
            bp.setBottom(lblStatus);


            handler= new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent event) { 
                    StringBuilder sb= new StringBuilder("Result:"); 
                    long n= Long.parseLong(tfNumber.getText());
                    for (long i=2; i<=n/2; i++) {
                        if (n % i == 0) sb.append("\n").append(i); 
                    }
                    lblResult.setText(sb.toString()); 
                }
            }; 
            btnCalc.setOnAction(handler);   //gibt andere Eventhaelnder
            tfNumber.setOnAction(handler);  //im feld selbst

            //tfNumber.setOnKeyReleased(ev -> checkInput() ); // lambdaausdruck Eventhaendler           
            //tfNumber.textProperty().addListener((p,o,nv)-> checkInput());

            BooleanBinding inputOk = Bindings.createBooleanBinding(
                    () -> tfNumber.getText().matches("[0-9]+"), 
                    tfNumber.textProperty());

            //BooleanBinding notInputOk= Bindings.createBooleanBinding(
            //        () -> !inputOk.getValue(),
            //       inputOk);


            BooleanBinding notInputOk = inputOk.not();
            btnCalc.disableProperty().bind(notInputOk);


            tfNumber.styleProperty().bind( Bindings.when(inputOk)
                    .then("")
                    .otherwise("-fx-focus-color: red;")); 
            lblStatus.textProperty().bind(
                    Bindings.when(inputOk) .then("")
                    .otherwise("Integer number expected"));



            //checkInput(); //fuer die erste pruefung damit keine eingabe ungueltig ist


            tfNumber.setTooltip(new Tooltip("Enter an int number pls"));
            btnCalc.setTooltip(new Tooltip("rechne aus"));

            //auto groesse (root,400,300)
            Scene scene = new Scene(bp); // anstatt root nun bp

            primaryStage.setScene(scene);
            primaryStage.setTitle("Factors");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private void checkInput() {
        String eingabe = tfNumber.getText();
        if ( eingabe.matches("[0-9]+")) {   //ausdruecke von 0-9
            tfNumber.setStyle("");          //normale farbe wenn gueltig
            btnCalc.setDisable(false);      //man kann auf den button klicken 
            tfNumber.setOnAction(handler);  //exception 
            lblStatus.setText("");          // bottom text wird veraendert 

        } else {
            tfNumber.setStyle("-fx-focus-color: red;"); 
            btnCalc.setDisable(true);
            tfNumber.setOnAction(null);
            lblStatus.setText("Integer number expected");
        }                                   

    }

    public static void main(String[] args) {
        launch(args);
    }
}



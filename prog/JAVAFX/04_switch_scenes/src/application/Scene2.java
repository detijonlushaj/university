package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scene2 {
    private static Stage stage;
    private static VBox layout = new VBox(20);
    private static Scene scene = new Scene(layout, 300, 300);
    private static Label label = new Label("This is the Second Scene");
    private static Button button = new Button("Backwards");
    private static TextField text = new TextField(); 
    
    public static void setLayout(Stage stage) {
        Scene2.stage = stage;
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label, button, text);
        text.setMaxWidth(100);
    }
    
    
    public static void switchScene(Scene scene) {
        button.setOnAction(e -> stage.setScene(scene));
    }
    
    public static Scene getScene() {
        return scene;
    }
    
    public static VBox getLayout() {
        return layout;
    }
    
    public static Label getLabel() {
        return label;
    }
    
    public static Button getButton() {
        return button;
    }
    
    public static TextField getTextField() {
        return text;
    }
}
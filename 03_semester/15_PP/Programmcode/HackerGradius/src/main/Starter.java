package main;
import javafx.application.Application;
import javafx.stage.Stage;
import menuObjects.MainMenuControllerNew;

import java.io.IOException;
/*
*  Just starts the mainMenu
* */
public class Starter extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MainMenuControllerNew mmcn = new MainMenuControllerNew();
        mmcn.initMenu(stage,"HackerGradius");
    }
    public static void main(String[] args) {launch(args);}
}
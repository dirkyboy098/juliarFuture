package com.juliar.gui;

/**
 * Created by AndreiM on 3/16/2017.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gui extends Application{

    Button button;
    Stage window;
    Scene loadingScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Juliar.Future");

        button = new Button();
        button.setText("Run as FCGI");

        StackPane layout = new StackPane();
        layout.getChildren().add(button);


        loadingScene = new Scene(layout,300,250);
        window.setScene(loadingScene);
        window.show();
    }
}

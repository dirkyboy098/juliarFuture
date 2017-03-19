package com.juliar.gui;

/**
 * Created by AndreiM on 3/16/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            Controller controller = new Controller(primaryStage);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juliar.fxml"));
            loader.setController(controller);
            Parent root = loader.load();
            primaryStage.setTitle("Juliar.Future");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Juliar Runtime Error");
            alert.setHeaderText("Cannot Launch Juliar!");
            alert.setContentText(" Error: "+e);
            alert.showAndWait();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}

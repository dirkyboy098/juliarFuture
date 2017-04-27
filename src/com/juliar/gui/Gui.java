package com.juliar.gui;

/**
 * Created by AndreiM on 3/16/2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.File;
import java.util.regex.Pattern;

public class Gui extends Application {

    @Override
    public void start(Stage stage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juliar.fxml"));
            loader.setControllerFactory(t -> new Controller(new Model()));
            stage.setTitle("Juliar.Future");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("juliarFutureIcon.png")));
            Font.loadFont(
                    getClass().getResource("Montserrat-Regular.ttf").toExternalForm(),
                    14
            );

            Scene scene = new Scene(loader.load());
            File jarPath=new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath=jarPath.getParentFile().getAbsolutePath();
            //scene.getStylesheets().add("file:///" + propertiesPath.replace("\\", "/") +"/juliar.css");
            String fullpath = propertiesPath.replace("\\", "/") +"/juliar.css";
            File f = new File(fullpath);
            if(f.exists()){
                scene.getStylesheets().add("file:///"+fullpath);
            }
            else {
                scene.getStylesheets().add(getClass().getResource("juliar.css").toExternalForm());
            }
            stage.setScene(scene);


            stage.show();
        }
        catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Juliar Runtime Error");
            alert.setHeaderText("Cannot Launch Juliar!");
            alert.setContentText(" Error: "+e);
            alert.showAndWait();
        }
    }

    /*private EventHandler<WindowEvent> onCloseEvent() {
        return (WindowEvent event) -> {
            try {
                closeAllTabs();
            } catch (IOException ex) {

            }
        };
    }*/


    public static void main(String[] args) {
        launch(args);
    }
}

package com.juliar.gui;

/**
 * Created by AndreiM on 3/16/2017.
 */

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Controller myController = new Controller(new Model());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juliar.fxml"));
            loader.setControllerFactory(t -> myController);

            final Image juliarImg = new Image(getClass().getResourceAsStream("juliarFutureIcon.png"));
            stage.getIcons().add(juliarImg);
            Font.loadFont(
                    getClass().getResource("Montserrat-Regular.ttf").toExternalForm(),
                    14
            );

            Scene scene = new Scene(loader.load());
            loadCSS(scene);

            stage.setTitle("Juliar.Future");
            stage.setScene(scene);
            myController.setScene(scene);
            stage.show();

            keyComb(scene);
        } catch (Exception e) {
            new GuiAlert(e, "Cannot Launch Juliar");
        }
    }

    public void loadCSS(Scene scene){
        String fullPath = getClass().getProtectionDomain().getCodeSource().getLocation() + "/juliar.css";
        File f = new File(fullPath);
        if (f.exists()) {
            scene.getStylesheets().add("file:///" + fullPath);
        } else {
            scene.getStylesheets().add(getClass().getResource("juliar.css").toExternalForm());
        }
    }


    public void keyComb(Scene scene){
        final KeyCombination kb_plus = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_minus = new KeyCodeCombination(KeyCode.MINUS, KeyCombination.CONTROL_DOWN);

        StringProperty cssProp = new SimpleStringProperty("");
        FXCSSUpdater updater = new FXCSSUpdater(scene);
        updater.bindCss(cssProp);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (kb_plus.match(ke) || kb_minus.match(ke)) {
                Font track = ((TextArea) scene.lookup("#areaOutText")).getFont();
                double size = track.getSize() + 1;
                if(kb_minus.match(ke)){
                    size -= 2;
                }
                cssProp.set(".text-area,.code-area .lineno,.paragraph-text .text {-fx-font-size: "+size+"px;}");
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}

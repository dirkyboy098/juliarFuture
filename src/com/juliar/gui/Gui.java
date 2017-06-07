package com.juliar.gui;

/**
 * Created by AndreiM on 3/16/2017.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Scene scene = SceneCreator.create(stage,"juliar.fxml","Juliar.Future");
            keyComb(scene);
            stage.setOnCloseRequest(event -> {
                if (CloseConfirm.closeApp().get() == ButtonType.OK){
                    Platform.exit();
                }
                event.consume();
            });
        } catch (Exception e) {
            new GuiAlert(e, "Cannot Launch Juliar");
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

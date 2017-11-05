package com.juliar.gui;

import javafx.application.Application;
import javafx.application.HostServices;
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
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        try {
            HostServices hostServices = getHostServices();
            Scene scene = SceneCreator.create(stage,"juliar.fxml","Juliar.Future - *New File*", hostServices);
            keyComb(scene);
            stage.setOnCloseRequest((WindowEvent event) -> {
                Optional<ButtonType> confirmation = CloseConfirm.closeApp();
                if (confirmation.isPresent() && confirmation.get() == ButtonType.OK){
                    Platform.exit();
                }
                event.consume();
            });
        } catch (Exception e) {
            new GuiAlert(e, "Cannot Launch Juliar");
        }
    }

    private void keyComb(Scene scene){
        final KeyCombination kbPlus = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.CONTROL_DOWN);
        final KeyCombination kbMinus = new KeyCodeCombination(KeyCode.MINUS, KeyCombination.CONTROL_DOWN);

        StringProperty cssProp = new SimpleStringProperty("");
        FXCSSUpdater updater = new FXCSSUpdater(scene);
        updater.bindCss(cssProp);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (kbPlus.match(ke) || kbMinus.match(ke)) {
                Font track = ((TextArea) scene.lookup("#areaOutText")).getFont();
                double size = track.getSize() + 1;
                if(kbMinus.match(ke)){
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

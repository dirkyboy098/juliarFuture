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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("juliar.fxml"));
            loader.setControllerFactory(t -> new Controller(new Model()));
            stage.setTitle("Juliar.Future");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("juliarFutureIcon.png")));
            Font.loadFont(
                    getClass().getResource("Montserrat-Regular.ttf").toExternalForm(),
                    14
            );

            Scene scene = new Scene(loader.load());
            File jarPath = new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath = jarPath.getParentFile().getAbsolutePath();
            String fullpath = propertiesPath.replace("\\", "/") + "/juliar.css";
            File f = new File(fullpath);
            if (f.exists()) {
                scene.getStylesheets().add("file:///" + fullpath);
            } else {
                scene.getStylesheets().add(getClass().getResource("juliar.css").toExternalForm());
            }

            Controller myController = loader.getController();
            myController.setScene(scene);

            stage.setScene(scene);
            stage.show();

            keyComb(scene);
        } catch (Exception e) {
            GuiAlert.GuiAlert(e, "Cannot Launch Juliar");
        }
    }


    public void keyComb(Scene scene){
        final KeyCombination kb_plus = new KeyCodeCombination(KeyCode.EQUALS, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_minus = new KeyCodeCombination(KeyCode.MINUS, KeyCombination.CONTROL_DOWN);

        StringProperty cssProp = new SimpleStringProperty("");
        FXCSSUpdater updater = new FXCSSUpdater(scene);
        updater.bindCss(cssProp);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (kb_plus.match(ke)) {
                TextArea track = (TextArea) scene.lookup("#areaOutText");
                double size = track.getFont().getSize() + 1;

                cssProp.set(".text-area,.code-area .lineno,.paragraph-text .text {-fx-font-size: "+size+"px;}");
            }
            else if(kb_minus.match(ke)){
                TextArea track = (TextArea) scene.lookup("#areaOutText");
                double size = track.getFont().getSize() - 1;

                cssProp.set(".text-area,.code-area .lineno,.paragraph-text .text {-fx-font-size: "+size+"px;}");
            }
        });
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

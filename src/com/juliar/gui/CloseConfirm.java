package com.juliar.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

import java.util.Optional;

/**
 * Created by AndreiM on 5/21/2017.
 */
public class CloseConfirm {
    public static Optional<ButtonType> close(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        CSSLoader.cssLoad(alert.getDialogPane());
        alert.setTitle("Close Tab Confirmation");
        alert.setHeaderText("You have unsaved content");
        alert.setContentText("Do you want to continue to close the tab?");
        return alert.showAndWait();
    }
    public static Optional<ButtonType> closeApp(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        CSSLoader.cssLoad(alert.getDialogPane());
        alert.setTitle("Close Juliar.Future Confirmation");
        alert.setHeaderText("You are closing Juliar.Future");
        alert.setContentText("Are you sure you want to exit?");
        return alert.showAndWait();
    }
}

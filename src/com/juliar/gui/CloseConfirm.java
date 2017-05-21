package com.juliar.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by AndreiM on 5/21/2017.
 */
public class CloseConfirm {
    public static Optional<ButtonType> close(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Close Tab Confirmation");
        alert.setHeaderText("You have unsaved content");
        alert.setContentText("Do you want to continue to close the tab?");
        return alert.showAndWait();
    }
}

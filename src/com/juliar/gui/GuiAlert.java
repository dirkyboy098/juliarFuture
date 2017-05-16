package com.juliar.gui;

import javafx.scene.control.Alert;

/**
 * Created by AndreiM on 5/15/2017.
 */
public class GuiAlert {
    public GuiAlert(Exception e, String header){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Juliar Error");
        alert.setHeaderText(header);
        alert.setContentText(" Error: " + e);
        alert.showAndWait();
    }
}

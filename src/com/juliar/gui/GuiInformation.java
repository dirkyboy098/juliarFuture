package com.juliar.gui;

import javafx.scene.control.Alert;

/**
 * Created by AndreiM on 5/20/2017.
 */
public class GuiInformation {
    public static void create (String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        CSSLoader.cssLoad(alert.getDialogPane());
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

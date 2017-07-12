package com.juliar.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;

import java.util.Optional;

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
    public static void about () {
        try {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("About Juliar IDE");
            dialog.getDialogPane().setPrefSize(600, 280);

            Window window = dialog.getDialogPane().getScene().getWindow();
            window.setOnCloseRequest(event -> window.hide());
            CSSLoader.cssLoad(dialog.getDialogPane());

            HBox hbox = new HBox();
            VBox vbox_1 = new VBox();
            VBox vbox_2 = new VBox();

            hbox.setPrefWidth(600);
            hbox.setPrefHeight(280);
            hbox.setPadding(new Insets(0));
            vbox_1.setPrefWidth(300);
            vbox_1.setPrefHeight(280);
            vbox_2.setPrefWidth(300);
            vbox_2.setPrefHeight(280);


            //hbox.setStyle("-fx-background-color: red;-fx-border-width: 0;");
            vbox_1.setStyle("-fx-background-color: #19e2c6;-fx-border-width: 0;");
            vbox_2.setStyle("-fx-background-color: #333a4c;-fx-border-width: 0;");


            StackPane pane = new StackPane();
            Image image = new Image(GuiInformation.class.getResourceAsStream("whitelogo.png"), 70, 70, false, false);
            ImageView iview = new ImageView(image);
            pane.setTranslateX(-30);
            pane.getChildren().add(iview);
            vbox_1.getChildren().add(pane);


            Label lbl2 = new Label("Juliar IDE ");
            lbl2.setFont(Font.font("Montserrat", FontWeight.BOLD, 36));
            vbox_1.getChildren().add(lbl2);

            Label lbl3 = new Label(" Alpha 0.01 · 07.03.2017   ");
            lbl3.setFont(Font.font("Montserrat", 14));
            vbox_1.getChildren().add(lbl3);
            vbox_1.setAlignment(Pos.CENTER_LEFT);
            vbox_1.setPadding(new Insets(20, 0, 0, 68));


            Label lbl = new Label("   Visit us at https://juliar.org/ , \nor just say hi: admin@juliar.org");
            lbl.setFont(Font.font("Montserrat", 14));
            vbox_2.getChildren().add(lbl);
            vbox_2.setAlignment(Pos.CENTER_LEFT);
            vbox_2.setPadding(new Insets(20, 44, 0, 44));


            hbox.getChildren().addAll(vbox_1, vbox_2);
            dialog.getDialogPane().setContent(hbox);
            dialog.getDialogPane().getChildren().remove(2);
            dialog.showAndWait();
        } catch (Exception e) {
            new GuiAlert(e, "Cannot Launch Juliar");
        }
    }
}

package com.juliar.gui;

import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by AndreiM on 5/20/2017.
 */
public class GuiInformation {
    private static final String FONT = "Montserrat";

    private GuiInformation() {}
    public static void create (String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        CSSLoader.cssLoad(alert.getDialogPane());
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public static void about (HostServices hostServices) {
        try {
            Dialog<String> dialog = new Dialog<>();
            dialog.setTitle("About Juliar IDE");
            dialog.getDialogPane().setPrefSize(600, 280);

            Window window = dialog.getDialogPane().getScene().getWindow();
            window.setOnCloseRequest(event -> window.hide());
            CSSLoader.cssLoad(dialog.getDialogPane());

            final Image juliarImg = new Image(SceneCreator.class.getResourceAsStream("juliarFutureIcon.png"));
            ((Stage) window).getIcons().add(juliarImg);

            HBox hbox = new HBox();
            VBox vbox1 = new VBox();
            VBox vbox2 = new VBox();

            hbox.setPrefWidth(600);
            hbox.setPrefHeight(280);
            hbox.setPadding(new Insets(0));
            vbox1.setPrefWidth(300);
            vbox1.setPrefHeight(280);
            vbox2.setPrefWidth(300);
            vbox2.setPrefHeight(280);


            vbox1.setStyle("-fx-background-color: #19e2c6;-fx-border-width: 0;");
            vbox2.setStyle("-fx-background-color: #333a4c;-fx-border-width: 0;");

            StackPane pane = new StackPane();
            Image image = new Image(GuiInformation.class.getResourceAsStream("whitelogo.png"), 70, 70, false, false);
            ImageView iview = new ImageView(image);
            pane.setTranslateX(-30);
            pane.getChildren().add(iview);
            vbox1.getChildren().add(pane);


            Label lbl2 = new Label("Juliar IDE ");
            lbl2.setFont(Font.font(FONT, FontWeight.BOLD, 36));
            vbox1.getChildren().add(lbl2);

            Date compdate = new Date(new File(GuiInformation.class.getProtectionDomain().getCodeSource().getLocation().getPath()).lastModified());
            LocalDate localDate = compdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int year  = localDate.getYear();
            int month = localDate.getMonthValue();
            int day   = localDate.getDayOfMonth();


            Label lbl3 = new Label(" Alpha 0.01 · " + String.format("%02d",month) + "." + String.format("%02d",day) + "."+year);
            lbl3.setFont(Font.font(FONT, 14));
            vbox1.getChildren().add(lbl3);
            vbox1.setAlignment(Pos.CENTER_LEFT);
            vbox1.setPadding(new Insets(20, 0, 0, 68));


            Hyperlink hyperlinkJuliar = new Hyperlink("https://juliar.org/");

            hyperlinkJuliar.setOnAction(event -> hostServices.showDocument("https://juliar.org"));

            Hyperlink hyperlinkEmail = new Hyperlink("admin@juliar.org");

            hyperlinkEmail.setOnAction(event -> hostServices.showDocument("mailto:admin@juliar.org"));
            Text text1 = new Text("Visit us at ");
            text1.setFont(Font.font(FONT, 14));
            text1.setStyle("-fx-fill: white;");
            Text text2 = new Text(", or just say hi: ");
            text2.setFont(Font.font(FONT, 14));
            text2.setStyle("-fx-fill: white;");

            hyperlinkJuliar.setStyle("-fx-text-fill: white;");
            hyperlinkJuliar.setFont(Font.font(FONT, 14));
            hyperlinkEmail.setStyle("-fx-text-fill: white;");
            hyperlinkEmail.setFont(Font.font(FONT, 14));

            TextFlow lbl = new TextFlow(text1, hyperlinkJuliar,  text2 , hyperlinkEmail);
            vbox2.getChildren().add(lbl);
            vbox2.setAlignment(Pos.CENTER_LEFT);
            vbox2.setPadding(new Insets(20, 44, 0, 44));


            hbox.getChildren().addAll(vbox1, vbox2);
            dialog.getDialogPane().setContent(hbox);
            dialog.getDialogPane().getChildren().remove(2);
            dialog.showAndWait();
        } catch (Exception e) {
            new GuiAlert(e, "Cannot Launch Juliar");
        }
    }
}

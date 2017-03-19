package com.juliar.gui;

import com.juliar.JuliarCompiler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by AndreiM on 3/18/2017.
 */
public class Controller implements Initializable {
    @FXML
    public MenuItem menu_exit;
    @FXML
    public MenuItem about;

    @FXML
    public TextField compileInputField;
    @FXML
    public Button compileInputBtn;
    @FXML
    public TextField compileOutputField;
    @FXML
    public Button compileOutputBtn;
    @FXML
    public Button compile;

    @FXML
    public TextField interpretInputField;
    @FXML
    public Button interpretInputBtn;
    @FXML
    public Button interpret;

    @FXML
    public TextField port;
    @FXML
    public Button runFCGI;


    private Stage stage;
    public Controller(Stage stage)
    {
        this.stage = stage;
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        // initialize your logic here: all @FXML variables will have been injected
       compile.setOnAction((event) -> {
           String[] args = {compileInputField.getText(),compileOutputField.getText()};
           JuliarCompiler.main(args);
        });
       interpret.setOnAction((event) -> {
           String[] args = {interpretInputField.getText()};
           JuliarCompiler.main(args);
       });
       runFCGI.setOnAction((event) -> {
           int myPort = Integer.parseInt(port.getText());
           String[] args = {"-DFCGI="+myPort};
           JuliarCompiler.main(args);
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Juliar.Future");
           alert.setHeaderText("FastCGI is running!");
           alert.setContentText("FastCGI is running!");
           alert.showAndWait();
       });
        menu_exit.setOnAction((event) -> {
            Platform.exit();
            System.exit(0);
        });

        about.setOnAction((event) -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About Juliar.Future");
            alert.setHeaderText("Juliar.Future");
            alert.setContentText("Juliar - Copyright (C) 2017");
            alert.showAndWait();
        });

        compileInputBtn.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                compileInputField.setText(file.getAbsolutePath());
            }
        });

        compileOutputBtn.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                compileOutputField.setText(file.getAbsolutePath());
            }
        });

        interpretInputBtn.setOnAction((event) -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                interpretInputField.setText(file.getAbsolutePath());
            }
        });
    }
}

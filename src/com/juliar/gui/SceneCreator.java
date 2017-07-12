package com.juliar.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by AndreiM on 5/31/2017.
 */
public class SceneCreator {
    public static Scene create(Stage stage, String resource, String title){
        try {
            FXMLLoader loader = new FXMLLoader(SceneCreator.class.getResource(resource));
            Controller myController = new Controller(new Model());
            loader.setControllerFactory(t -> myController);

            final Image juliarImg = new Image(SceneCreator.class.getResourceAsStream("juliarFutureIcon.png"));
            stage.getIcons().add(juliarImg);
            Font.loadFont(
                    SceneCreator.class.getResource("Montserrat-Regular.ttf").toExternalForm(),
                    14
            );
            Font.loadFont(
                    SceneCreator.class.getResource("Montserrat-Bold.ttf").toExternalForm(),
                    36
            );

            Scene scene = new Scene(loader.load());
            CSSLoader.cssLoad(scene);

            stage.setTitle(title);
            stage.setScene(scene);
            myController.setScene(scene);
            stage.show();
            return scene;
        } catch (Exception e) {
            new GuiAlert(e, "Cannot Launch Juliar");
        }
        return new Scene(new Pane());
    }
}

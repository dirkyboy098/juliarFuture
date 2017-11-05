package com.juliar.gui;

import javafx.scene.Scene;
import javafx.scene.control.DialogPane;

import java.io.File;

/**
 * Created by AndreiM on 5/25/2017.
 */
public class CSSLoader {
    private CSSLoader() {}
    public static void cssLoad(DialogPane dialogPane){
        File jarPath=new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
        String fullPath = propertiesPath.replace("\\", "/") +"/juliar.css";
        File f = new File(fullPath);
        if (f.exists()) {
            dialogPane.getStylesheets().add("file:///" + fullPath);
        } else {
            dialogPane.getStylesheets().add(CSSLoader.class.getResource("juliar.css").toExternalForm());
        }
    }

    public static void cssLoad(Scene scene){
        File jarPath=new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
        String fullPath = propertiesPath.replace("\\", "/") +"/juliar.css";
        File f = new File(fullPath);
        if (f.exists()) {
            scene.getStylesheets().add("file:///" + fullPath);
        } else {
            scene.getStylesheets().add(CSSLoader.class.getResource("juliar.css").toExternalForm());
        }
    }

}

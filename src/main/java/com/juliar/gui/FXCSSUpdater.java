package com.juliar.gui;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Class that handles the update of the CSS on the scene or any parent.
 *
 * Since in JavaFX, stylesheets can only be loaded from files or URLs, it implements a handler to create a magic "internal:stylesheet.css" url for our css string
 * see : https://github.com/fxexperience/code/blob/master/FXExperienceTools/src/com/fxexperience/tools/caspianstyler/CaspianStylerMainFrame.java
 * and : http://stackoverflow.com/questions/24704515/in-javafx-8-can-i-provide-a-stylesheet-from-a-string
 */
class FXCSSUpdater {

    private String css;

    private Scene scene;

    FXCSSUpdater(Scene scene) {
        this.scene = scene;
        URL.setURLStreamHandlerFactory(new StringURLStreamHandlerFactory());
    }

    public void bindCss(StringProperty cssProperty){
        cssProperty.addListener(e -> {
            this.css = cssProperty.get();
            Platform.runLater(()-> scene.getStylesheets().add("internal:"+System.nanoTime()+"stylesheet.css"));
        });
    }
    /**
     * URLConnection implementation that returns the css string property, as a stream, in the getInputStream method.
     */
    private class StringURLConnection extends URLConnection {
        StringURLConnection(URL url){
            super(url);
        }

        @Override
        public void connect() throws IOException { /*Does Nothing. Otherwise it displays a warning message*/}

        @Override public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(css.getBytes("UTF-8"));
        }
    }

    /**
     * URL Handler to create magic "internal:stylesheet.css" url for our css string
     */
    private class StringURLStreamHandlerFactory implements URLStreamHandlerFactory {

        private final URLStreamHandler streamHandler = new URLStreamHandler(){
            @Override
            protected URLConnection openConnection(URL url) throws IOException {
                if (url.toString().toLowerCase().endsWith(".css")) {
                    return new StringURLConnection(url);
                }
                throw new FileNotFoundException();
            }
        };

        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            if ("internal".equals(protocol)) {
                return streamHandler;
            }
            return null;
        }
    }
}
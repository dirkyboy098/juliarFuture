package com.juliar.gui;

import javafx.scene.control.TextArea;

/**
 * Created by AndreiM on 4/11/2017.
 */
public class JRLTab {
    private TextFile jrlTextFile;

    private TextArea jrlOutput;

    private boolean changed = false;


    public void textChanged(){
        changed = true;
    }
}

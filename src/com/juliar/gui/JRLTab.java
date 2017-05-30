package com.juliar.gui;

import javafx.scene.control.Tab;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import org.fxmisc.richtext.CodeArea;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by AndreiM on 4/11/2017.
 */
public class JRLTab {
    private Tab jrlTab;
    private Circle jrlGraphic;
    private TextFile jrlFileName = null;
    private File jrlFile;
    private CodeArea jlrCodeArea;
    private boolean edited = true;

    public File getJrlFile() {
        return jrlFile;
    }

    public void setJrlFile(File jrlFile) {
        this.jrlFile = jrlFile;
    }

    public Tab getJrlTab() {
        return jrlTab;
    }

    public void setJrlTab(Tab jrlTab) {
        this.jrlTab = jrlTab;
    }

    public Circle getJrlGraphic() {
        return jrlGraphic;
    }

    public void setJrlGraphic(Circle jrlGraphic) {
        this.jrlGraphic = jrlGraphic;
    }

    public TextFile getJrlFileName() {
        return jrlFileName;
    }

    public void setJrlFileName(TextFile jrlFileName) {
        this.jrlFileName = jrlFileName;
    }

    public CodeArea getJlrCodeArea() {
        return jlrCodeArea;
    }

    public void setJlrCodeArea(CodeArea jlrCodeArea) {
        this.jlrCodeArea = jlrCodeArea;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        //if(this.edited != edited) {
            if (edited) {
                this.jrlGraphic.setFill(Color.rgb(242, 240, 34));
            } else {
                this.jrlGraphic.setFill(Color.rgb(131, 207, 23));
            }
            this.edited = edited;
        //}
    }

    public static String newText(int size) {
        Date now = new Date();
        String formattedDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).format(now);
        return "/* \r\n" +
                "\tTitle: Untitled (" + size + ") \r\n" +
                "\tAuthor: "+System.getProperty("user.name")+" \r\n" +
                "\tDate: " + formattedDate + "\r\n" +
                "*/ \r\n\r\n" +
                "function main()= {\r\n" +
                "\tprintLine(\"Hello World\");\r\n}\r\n";
    }
}

package com.juliar.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javafx.scene.control.Alert;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Tab;

import java.io.File;
import java.util.Arrays;

import com.juliar.JuliarCompiler;

import java.io.*;
import java.lang.ProcessBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

/**
 * Created by AndreiM on 3/18/2017.
 */
public class Controller {
    @FXML
    private TextArea areaOutText;

    @FXML
    private TabPane tabPane;

    private TextFile currentTextFile;

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    /*@FXML
    public void tabPane.setOnCloseRequest(new EventHandler<Event>(){
        @Override void handle(Event e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("TEST");
            alert.setTitle("TEST");
            alert.setContentText("TEST");
            alert.show();
        }
    });*/

    @FXML
    private void onSave() {
        if(currentTextFile == null) onSaveAs();
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        TextArea tabContent = (TextArea) tab.getContent();

        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(tabContent.getText().split("\n")));
        model.save(textFile);
    }

    @FXML
    private void onSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file =  fileChooser.showSaveDialog(null);
        if (file != null) {

            Tab tab = tabPane.getSelectionModel().getSelectedItem();
            TextArea tabContent = (TextArea) tab.getContent();

            TextFile textFile = new TextFile(file.toPath(), Arrays.asList(tabContent.getText().split("\n")));
            model.save(textFile);
            tabPane.getSelectionModel().getSelectedItem().setText(textFile.getName());
            currentTextFile = textFile;

        }
    }

    @FXML
    private void onRunInterpreter(){

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        JuliarCompiler compiler = new JuliarCompiler();

        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        VirtualizedScrollPane vp = (VirtualizedScrollPane) tab.getContent();
        CodeArea ca = (CodeArea) vp.getContent();

        areaOutText.appendText(ca.getText());


        //areaOutText.appendText(tabContent.getText());

        InputStream is = new ByteArrayInputStream(ca.getText().getBytes());
        compiler.compile(is, "/", false, false);

        System.out.flush();
        System.setOut(old);
        areaOutText.clear();
        areaOutText.appendText(baos.toString());
    }

    @FXML
    private void onCompileAndRun(){

        /*TODO */
    }

    @FXML
    private void onRefresh(){
        File jarPath=new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
        tabPane.getScene().getStylesheets().clear();
        String fullpath = propertiesPath.replace("\\", "/") +"/juliar.css";
        File f = new File(fullpath);
        if(f.exists()){
            tabPane.getScene().getStylesheets().add("file:///"+fullpath);
        }
        else {
            tabPane.getScene().getStylesheets().add(getClass().getResource("juliar.css").toExternalForm());
        }
    }

    @FXML
    private void onRunFCGI(){
        ProcessBuilder pb = new ProcessBuilder("java","-DFCGI_PORT=9000", "-jar", new java.io.File(Controller.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath())
                .getName());
        try {
            File log = new File("log");
            pb.redirectErrorStream(true);
            pb.redirectOutput(log);
            Process p = pb.start();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Juliar FastCGI");
            alert.setHeaderText(null);
            alert.setContentText("Juliar Successfully launched!");
            alert.showAndWait();
        }
        catch(IOException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Juliar FastCGI Cannot Start");
            alert.setHeaderText("Cannot Start a new instance of Juliar!");
            alert.setContentText(" Error: "+e);
            alert.showAndWait();
        }
    }

    @FXML
    private void onLoad() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            IOResult<TextFile> io = model.load(file.toPath());

            if (io.isOk() && io.hasData()) {
                currentTextFile = io.getData();

                Tab tab = new Tab("● Untitled (" + (tabPane.getTabs().size() + 1)+")");
                tabPane.getTabs().add(tab);
                tabPane.getSelectionModel().select(tab);

                CodeArea codeArea = new CodeArea();
                codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

                codeArea.richChanges()
                        .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                        .subscribe(change -> {
                            codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText()));
                        });
                //codeArea.replaceText(0, 0, "");
                //TextArea loadedTextArea = new TextArea();
                //tab.setContent(loadedTextArea);
                tab.setContent(new VirtualizedScrollPane<>(codeArea));

                tab.setText("● "+file.toPath().getFileName().toString());
                currentTextFile.getContent().forEach(line -> codeArea.appendText(line + "\n"));
            } else {
                System.out.println("Failed");
            }
        }
    }

    @FXML
    private void onExit() {
        model.close();
    }

    @FXML
    private void onNew(){
        Tab tab = new Tab("● Untitled (" + (tabPane.getTabs().size() + 1)+")");
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);

        CodeArea codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

        codeArea.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText()));
                });
        //codeArea.replaceText(0, 0, "");
        //TextArea loadedTextArea = new TextArea();
        //tab.setContent(loadedTextArea);
        tab.setContent(new VirtualizedScrollPane<>(codeArea));
        currentTextFile = null;
    }

    @FXML
    private void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("About Juliar.Future");
        alert.setTitle("Juliar.Future");
        alert.setContentText("Juliar - Copyright (C) 2017");
        alert.show();
    }


    private static final String[] KEYWORDS = new String[] {
            "break",
            "class",
            "double",
            "else",
            "float",
            "for",
            "function",
            "int",
            "if",
            "return",
            "string",
            "while",
    };

    private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
    private static final String PAREN_PATTERN = "\\(|\\)";
    private static final String BRACE_PATTERN = "\\{|\\}";
    private static final String BRACKET_PATTERN = "\\[|\\]";
    private static final String SEMICOLON_PATTERN = "\\;";
    private static final String STRING_PATTERN = "\"([^\"\\\\]|\\\\.)*\"";
    private static final String COMMENT_PATTERN = "//[^\n]*" + "|" + "/\\*(.|\\R)*?\\*/";

    private static final Pattern PATTERN = Pattern.compile(
            "(?<KEYWORD>" + KEYWORD_PATTERN + ")"
                    + "|(?<PAREN>" + PAREN_PATTERN + ")"
                    + "|(?<BRACE>" + BRACE_PATTERN + ")"
                    + "|(?<BRACKET>" + BRACKET_PATTERN + ")"
                    + "|(?<SEMICOLON>" + SEMICOLON_PATTERN + ")"
                    + "|(?<STRING>" + STRING_PATTERN + ")"
                    + "|(?<COMMENT>" + COMMENT_PATTERN + ")"
    );

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        Matcher matcher = PATTERN.matcher(text);
        int lastKwEnd = 0;
        StyleSpansBuilder<Collection<String>> spansBuilder
                = new StyleSpansBuilder<>();
        while(matcher.find()) {
            String styleClass =
                    matcher.group("KEYWORD") != null ? "keyword" :
                            matcher.group("PAREN") != null ? "paren" :
                                    matcher.group("BRACE") != null ? "brace" :
                                            matcher.group("BRACKET") != null ? "bracket" :
                                                    matcher.group("SEMICOLON") != null ? "semicolon" :
                                                            matcher.group("STRING") != null ? "string" :
                                                                    matcher.group("COMMENT") != null ? "comment" :
                                                                            null; /* never happens */ assert styleClass != null;
            spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
            spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
            lastKwEnd = matcher.end();
        }
        spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
        return spansBuilder.create();
    }

}

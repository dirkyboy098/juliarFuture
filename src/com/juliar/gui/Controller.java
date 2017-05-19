package com.juliar.gui;

import com.juliar.JuliarCompiler;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.FileChooser;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AndreiM on 3/18/2017.
 */
public class Controller {
    public boolean compilerRunning = false;
    public Thread thread;

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

    @FXML
    public Button runBtn;

    @FXML
    public TextArea areaOutText;

    @FXML
    public TabPane tabPane;

    private TextFile currentTextFile;

    private Model model;

    private Scene scene;

    public void setScene(Scene scene) { this.scene = scene; }

    public Controller(Model model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        newfile();
        final KeyCombination kb_enter = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_new = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_load = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_save = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_reload = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_closetab = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);

        tabPane.getParent().addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (kb_enter.match(ke)) {
                this.interpret();
            }
            if (kb_new.match(ke)) {
                this.newfile();
            }
            if (kb_load.match(ke)) {
                this.loadfile();
            }
            if (kb_save.match(ke)) {
                this.savefile();
            }
            if (kb_reload.match(ke)) {
                this.reloadfile();
            }
            if (kb_closetab.match(ke)) {
                this.closetab();
            }
        });

    }

    public void closetab(){
        tabPane.getTabs().remove( tabPane.getSelectionModel().getSelectedIndex());
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

    public void savefile(){
        if(currentTextFile == null) onSaveAs();
        Tab tab = tabPane.getSelectionModel().getSelectedItem();

        VirtualizedScrollPane<CodeArea> vp = (VirtualizedScrollPane<CodeArea>) tab.getContent();
        CodeArea ca = vp.getContent();
        TextFile textFile = new TextFile(currentTextFile.getFile(), Arrays.asList(ca.getText().split("\n")));
        model.save(textFile);
    }


    @FXML
    public void onWhatsNew(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("What's New");
        alert.setHeaderText("Juliar New Features");
        alert.setContentText("-Control + to increase size of text \r\n-Control - to decrease size of text \r\n-Control + Enter - Compile");
        alert.showAndWait();
    }

    @FXML
    public void onSave() {
        this.savefile();
    }

    @FXML
    public void onSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file =  fileChooser.showSaveDialog(null);
        if (file != null) {

            Tab tab = tabPane.getSelectionModel().getSelectedItem();
            VirtualizedScrollPane<CodeArea> vp = (VirtualizedScrollPane<CodeArea>) tab.getContent();
            CodeArea ca = vp.getContent();
            TextFile textFile = new TextFile(file.toPath(), Arrays.asList(ca.getText().split("\n")));
            model.save(textFile);
            tabPane.getSelectionModel().getSelectedItem().setText(textFile.getName());
            currentTextFile = textFile;

        }
    }

    public void interpret(){
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(0.0, 0.0,
                0.0, 21.0,
                15.0, 10.5);
        triangle.setFill(Color.WHITE);

        if(compilerRunning == true){
            thread.interrupt();
            compilerRunning = false;
            runBtn.setGraphic(triangle);
            areaOutText.appendText("\r\nInterrupted on " + LocalDateTime.now());
            return;
        }
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
        VirtualizedScrollPane<CodeArea> vp = (VirtualizedScrollPane<CodeArea>) tab.getContent();
        CodeArea ca = vp.getContent();

        //areaOutText.appendText(ca.getText());
        areaOutText.clear();
        areaOutText.appendText("Starting Interpreter at: " + LocalDateTime.now() + "\r\n");
        long startTime = System.nanoTime();
        //areaOutText.appendText(tabContent.getText());

        InputStream is = new ByteArrayInputStream(ca.getText().getBytes());

        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() {
                compilerRunning = true;
                compiler.compile(is, "/", false, false);
                return null;
            }
        };
        task.setOnSucceeded(taskFinishEvent -> {
            System.out.flush();
            System.setOut(old);
            areaOutText.appendText(baos.toString());
            areaOutText.appendText("\r\nCompleted execution in " + ((System.nanoTime() - startTime) / 1000000) + "ms");
            runBtn.setGraphic(triangle);
            compilerRunning = false;
        });
        Polygon square = new Polygon();
        square.getPoints().addAll(0.0, 0.0,
                0.0, 21.0,
                21.0, 21.0,
                21.0, 0.0);
        square.setFill(Color.WHITE);
        runBtn.setGraphic(square);
        thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void onRunInterpreter(){
        interpret();
    }

    @FXML
    public void onCompileAndRun(){ /*TODO */}

    public void reloadfile(){
        File jarPath=new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
        scene.getStylesheets().clear();
        String fullpath = propertiesPath.replace("\\", "/") +"/juliar.css";
        File f = new File(fullpath);
        if(f.exists()){
            scene.getStylesheets().add("file:///"+fullpath);
        }
        else {
            scene.getStylesheets().add(getClass().getResource("juliar.css").toExternalForm());
        }
    }

    @FXML
    public void onRefresh(){
        this.reloadfile();
    }

    @FXML
    public void onRunFCGI(){
        ProcessBuilder pb = new ProcessBuilder("java","-DFCGI_PORT=9000", "-jar", new File(Controller.class.getProtectionDomain()
                .getCodeSource()
                .getLocation()
                .getPath())
                .getName());
        try {
            File log = new File("log");
            pb.redirectErrorStream(true);
            pb.redirectOutput(log);
            pb.start();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Juliar FastCGI");
            alert.setHeaderText(null);
            alert.setContentText("Juliar Successfully launched!");
            alert.showAndWait();
        }
        catch(IOException e){
            new GuiAlert(e, "Juliar FastCGI Cannot Start: Cannot Start a new instance of Juliar!");
        }
    }


    public void loadfile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            IOResult<TextFile> io = model.load(file.toPath());

            if (io.isOk() && io.hasData()) {
                currentTextFile = io.getData();

                Tab tab = new Tab();
                tabPane.getTabs().add(tab);
                tabPane.getSelectionModel().select(tab);
                createTab(tab,file);

            } else {
                System.out.println("Failed");
            }
        }
    }


    private void createTab(Tab tab,File file){
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

        tab.setText(file.toPath().getFileName().toString());
        Circle c = new Circle(0, 0, 3);
        c.setFill(Color.rgb(131,207,23));
        tab.setGraphic(c);
        currentTextFile.getContent().forEach(line -> codeArea.appendText(line + "\n"));

    }

    @FXML
    public void onLoad() {
        this.loadfile();
    }

    @FXML
    public void onExit() {
        model.close();
    }

    public void newfile(){
        Tab tab = new Tab("Untitled (" + (tabPane.getTabs().size() + 1)+")");
        Circle c = new Circle(0, 0, 3);
        c.setFill(Color.rgb(131,207,23));
        tab.setGraphic(c);
        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);

        CodeArea codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

        codeArea.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved())) // XXX
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, computeHighlighting(codeArea.getText()));
                });
        tab.setContent(new VirtualizedScrollPane<>(codeArea));
        currentTextFile = null;

        Date now = new Date();
        String formattedDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).format(now);
        codeArea.appendText("/* \r\n" +
                "\tTitle: Juliar Template \r\n" +
                "\tAuthor: Juliar \r\n" +
                "\tDate: "+formattedDate+"\r\n"+
                "*/ \r\n\r\n"+
                "function main()= {\r\n"+
                "\tprintLine(\"Hello World\");\r\n}\r\n"
        );

    }

    @FXML
    public void onNew(){
        this.newfile();
    }

    @FXML
    public void onAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("About Juliar.Future");
        alert.setTitle("Juliar.Future");
        alert.setContentText("Juliar - Copyright (C) 2017");
        alert.show();
    }

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

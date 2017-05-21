package com.juliar.gui;

import com.juliar.JuliarCompiler;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AndreiM on 3/18/2017.
 */
public class Controller {
    public boolean compilerRunning = false;
    public Thread thread;

    @FXML
    public Button runBtn;

    @FXML
    public TextArea areaOutText;

    @FXML
    public TabPane tabPane;

    private Model model;

    private Scene scene;

    public void setScene(Scene scene) { this.scene = scene; }

    public Controller(Model model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        onNew();
        final KeyCombination kb_enter = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_new = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_load = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_save = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_reload = new KeyCodeCombination(KeyCode.R, KeyCombination.CONTROL_DOWN);
        final KeyCombination kb_closetab = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);

        tabPane.getParent().addEventFilter(KeyEvent.KEY_PRESSED, ke -> {
            if (kb_enter.match(ke)) {
                this.onRunInterpreter();
            }
            if (kb_new.match(ke)) {
                this.onNew();
            }
            if (kb_load.match(ke)) {
                this.onLoad();
            }
            if (kb_save.match(ke)) {
                this.onSave();
            }
            if (kb_reload.match(ke)) {
                this.onRefresh();
            }
            if (kb_closetab.match(ke)) {
                this.closetab();
            }
        });
        tabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            jrlID = tabPane.getSelectionModel().getSelectedIndex();
            //new GuiAlert(new Exception(),"JRLID: "+jrlID+ " JRLLENG: " + jrltabs.size()+ " TEST:" + jrltabs.get(jrlID).getJrlFile().getPath().toString());
        });
    }

    public ArrayList<JRLTab> jrltabs = new ArrayList<>();
    public Integer jrlID = 0;


    public void closetab(){
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        final EventType<Event> closeRequestEventType = Tab.TAB_CLOSE_REQUEST_EVENT;
        final Event closeRequestEvent = new Event(closeRequestEventType);
        Event.fireEvent(tab, closeRequestEvent);

        final EventType<Event> closedEventType = Tab.CLOSED_EVENT;
        final Event closedEvent = new Event(closedEventType);
        Event.fireEvent(tab, closedEvent);

        tabPane.getTabs().remove(tab);
    }

    @FXML
    public void onUndo(){
        jrltabs.get(jrlID).getJlrCodeArea().undo();
    }

    @FXML
    public void onRedo(){
        jrltabs.get(jrlID).getJlrCodeArea().redo();
    }

    @FXML
    public void onNew(){
        JRLTab jrlTab = new JRLTab();
        createTab(jrlTab);
        jrlTab.setEdited(true);
        jrltabs.add(jrlTab);
    }


    @FXML
    public void onLoad() {
        JRLTab jrlTab = new JRLTab();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File("./"));
        File file = fileChooser.showOpenDialog(null);
        jrlTab.setJrlFile(file);
        if (file != null) {
            IOResult<TextFile> io = model.load(file.toPath());

            if (io.isOk() && io.hasData()) {
                TextFile tFile = io.getData();
                jrlTab.setJrlFileName(tFile);
                createTab(jrlTab);
                jrltabs.add(jrlTab);
                jrlTab.setEdited(false);
            }
        }
    }

    public void createTab(JRLTab jrlTab){
        int tabSize = jrltabs.size();
        CodeArea codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved()))
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, Highlighter.computeHighlighting(codeArea.getText()));
                    jrlTab.setEdited(true);
                });
        jrlTab.setJlrCodeArea(codeArea);

        Tab tab = new Tab();
        tab.setText("Untitled (" + (tabSize)+")");
        jrlTab.setJrlTab(tab);
        tab.setOnCloseRequest(e -> {
            int myid = jrlID;
            jrltabs.remove(myid);
            //e.consume();
            //new GuiAlert(new Exception(),"MYID" + myid + "JRLID: "+jrlID+ " JRLLENG: " + jrltabs.size()+ " TEST:");
        });

        Circle c = Shapes.tabCircle();
        tab.setGraphic(c);
        jrlTab.setJrlGraphic(c);

        tabPane.getTabs().add(tab);
        tabPane.getSelectionModel().select(tab);

        tab.setContent(new VirtualizedScrollPane<>(codeArea));


        if(jrlTab.getJrlFileName() != null){
            tab.setText(jrlTab.getJrlFile().toPath().getFileName().toString());
            jrlTab.getJrlFileName().getContent().forEach(line -> codeArea.appendText(line + "\n"));
        }
        else{
            codeArea.appendText(JRLTab.newText(tabSize));
        }
    }

    @FXML
    public void onSave() {
        if(jrltabs.get(jrlID).getJrlFileName() == null) onSaveAs();
        TextFile textFile = new TextFile(jrltabs.get(jrlID).getJrlFile().toPath(), Arrays.asList(jrltabs.get(jrlID).getJlrCodeArea().getText().split("\n")));
        model.save(textFile);
        jrltabs.get(jrlID).setEdited(false);
    }

    @FXML
    public void onSaveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        File file =  fileChooser.showSaveDialog(null);
        if (file != null) {
            jrltabs.get(jrlID).setJrlFile(file);
            TextFile textFile = new TextFile(jrltabs.get(jrlID).getJrlFile().toPath(), Arrays.asList(jrltabs.get(jrlID).getJlrCodeArea().getText().split("\n")));
            model.save(textFile);
            jrltabs.get(jrlID).getJrlTab().setText(textFile.getName());
            jrltabs.get(jrlID).setJrlFileName(textFile);
            jrltabs.get(jrlID).setEdited(false);
        }
    }

    @FXML
    public void onRunInterpreter(){
        if(compilerRunning){
            thread.interrupt();
            compilerRunning = false;
            runBtn.setGraphic(Shapes.btnTriangle());
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

        areaOutText.clear();
        areaOutText.appendText("Starting Interpreter at: " + LocalDateTime.now() + "\r\n");
        long startTime = System.nanoTime();

        InputStream is = new ByteArrayInputStream(jrltabs.get(jrlID).getJlrCodeArea().getText().getBytes());

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
            runBtn.setGraphic(Shapes.btnTriangle());
            compilerRunning = false;
        });
        runBtn.setGraphic(Shapes.btnSquare());
        thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML
    public void onRefresh(){
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
            GuiInformation.create("Juliar FastCGI","","Juliar Successfully launched!");
        }
        catch(IOException e){
            new GuiAlert(e, "Juliar FastCGI Cannot Start: Cannot Start a new instance of Juliar!");
        }
    }

    @FXML
    public void onExit() {
        model.close();
    }

    @FXML
    public void onAbout() { GuiInformation.create("About Juliar.Future","Juliar.Future","Juliar - Copyright (C) 2017"); }

    @FXML
    public void onWhatsNew(){ GuiInformation.create("What's New","Juliar New Features",
            "-Control + to increase size of text \r\n-Control - to decrease size of text \r\n-Control + Enter - Compile");}
}

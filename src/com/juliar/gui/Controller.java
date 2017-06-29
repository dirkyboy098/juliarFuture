package com.juliar.gui;

import com.juliar.JuliarCompiler;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AndreiM on 3/18/2017.
 */
public class Controller {
    public ArrayList<JRLTab> jrltabs = new ArrayList<>();
    public Integer jrlID = 0;
    public boolean compilerRunning = false;
    public Thread thread;

    @FXML
    public Button runBtn;

    @FXML
    public TextArea areaOutText;

    @FXML
    public TextArea areaErrorText;

    @FXML
    public TabPane tabPane;

    @FXML
    public TabPane tabPaneOut;

    private Model model;

    private Scene scene;

    public void addPackage(){
        new JuliarModule();
    }

    public void setScene(Scene scene) {
        scene.setOnDragOver(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY);
            } else {
                event.consume();
            }
        });

        // Dropping over surface
        scene.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                success = true;
                for (File file:db.getFiles()) {
                    JRLTab jrlTab = new JRLTab();
                    jrlTab.setJrlFile(file);
                    IOResult<TextFile> io = model.load(file.toPath());

                    if (io.isOk() && io.hasData()) {
                        TextFile tFile = io.getData();
                        jrlTab.setJrlFileName(tFile);
                        jrlTab = createTab(jrlTab);
                        jrlTab.getJlrCodeArea().getUndoManager().mark();
                        jrlTab.setEdited(false);
                        jrltabs.add(jrlTab);
                    }
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });
        this.scene = scene;
    }

    public Controller(Model model) {
        this.model = model;
    }

    @FXML
    public void onException(){
        new GuiAlert(new Exception(),"Triggered an Error");
    }

    @FXML
    public void initialize() {
        File jarPath=new File(Gui.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath=jarPath.getParentFile().getAbsolutePath();
        String fullPath = propertiesPath.replace("\\", "/") +"/test.jrl";
        File f = new File(fullPath);
        if (f.exists()) {
            JRLTab jrlTab = new JRLTab();
            jrlTab.setJrlFile(f);
            IOResult<TextFile> io = model.load(f.toPath());
            if (io.isOk() && io.hasData()) {
                TextFile tFile = io.getData();
                jrlTab.setJrlFileName(tFile);
                jrlTab = createTab(jrlTab);
                jrlTab.getJlrCodeArea().getUndoManager().mark();
                jrlTab.setEdited(false);
                jrltabs.add(jrlTab);
            }
            onRunInterpreter();
        } else {
            onNew();
        }
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
            try {
                String titlename = "Juliar.Future - *New File*";
                if((jrlID < jrltabs.size()) && (jrltabs.get(jrlID).getJrlFile() != null)){
                    titlename = "Juliar.Future - " + jrltabs.get(jrlID).getJrlFile().toPath().toString();
                }
                ((Stage) scene.getWindow()).setTitle(titlename);
            } catch (Exception e){
                new GuiAlert(e, "Something wrong with setting title" + jrltabs.size());
            }
        });
    }

    public void closetab(){
        Tab tab = tabPane.getSelectionModel().getSelectedItem();
        EventHandler<Event> handler = tab.getOnCloseRequest();
        if (null != handler) {
            handler.handle(null);
        }
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
    public void onMoveTo() {
        TextInputDialog dialog = new TextInputDialog("1");
        CSSLoader.cssLoad(dialog.getDialogPane());
        dialog.setTitle("Go to Line Number");
        dialog.setHeaderText("Go to Line Number");
        dialog.setContentText("Line:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> {
            CodeArea area = jrltabs.get(jrlID).getJlrCodeArea();
            int pos = area.getAbsolutePosition(Integer.parseInt(name) - 1, 0);
            area.moveTo(pos);
            area.requestFocus();
        });
    }

    @FXML
    public void onNew(){
        JRLTab jrlTab = new JRLTab();
        jrlTab = createTab(jrlTab);
        jrltabs.add(jrlTab);
        jrlTab.getJlrCodeArea().getUndoManager().mark();
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
                jrlTab = createTab(jrlTab);
                jrlTab.getJlrCodeArea().getUndoManager().mark();
                jrlTab.setEdited(false);
                jrltabs.add(jrlTab);
                String titleName = "Juliar.Future - " + file.toPath().toString();
                ((Stage) scene.getWindow()).setTitle(titleName);
            }
        }
    }

    public JRLTab createTab(JRLTab jrlTab){
        int tabSize = jrltabs.size();
        CodeArea codeArea = new CodeArea();
        jrlTab.setJlrCodeArea(codeArea);
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));
        codeArea.richChanges()
                .filter(ch -> !ch.getInserted().equals(ch.getRemoved()))
                .subscribe(change -> {
                    codeArea.setStyleSpans(0, Highlighter.computeHighlighting(codeArea.getText()));
                    if(jrlTab.getJlrCodeArea().getUndoManager().isAtMarkedPosition()) {
                        jrlTab.setEdited(false);
                        //new GuiAlert(new Exception(),"AtMarked: " + codeArea.getUndoManager().atMarkedPositionProperty() + "Edited: false" + codeArea.getUndoManager().getCurrentPosition());
                    }
                    else{
                        jrlTab.setEdited(true);
                        //new GuiAlert(new Exception(),"AtMarked: " + codeArea.getUndoManager().atMarkedPositionProperty() +"Edited: true" +  codeArea.getUndoManager().getCurrentPosition());
                    }
                });


        Tab tab = new Tab();
        tab.setText("Untitled (" + (tabSize)+")");
        jrlTab.setJrlTab(tab);
        tab.setOnCloseRequest(e -> {
            int myid = jrlID;
            if(jrltabs.get(myid).isEdited()){
                if (CloseConfirm.close().get() == ButtonType.OK){
                    tabPane.getTabs().remove(jrltabs.get(myid).getJrlTab());
                    jrltabs.remove(myid);
                }
            }
            else {
                tabPane.getTabs().remove(jrltabs.get(myid).getJrlTab());
                jrltabs.remove(myid);
            }
            e.consume();
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
        jrlTab.getJlrCodeArea().getUndoManager().forgetHistory();
        return jrlTab;
    }

    @FXML
    public void onSave() {
        if(jrltabs.get(jrlID).getJrlFileName() == null) onSaveAs();
        TextFile textFile = new TextFile(jrltabs.get(jrlID).getJrlFile().toPath(), Arrays.asList(jrltabs.get(jrlID).getJlrCodeArea().getText().split("\n")));
        model.save(textFile);
        jrltabs.get(jrlID).setEdited(false);
        jrltabs.get(jrlID).getJlrCodeArea().getUndoManager().mark();
        String titleName = "Juliar.Future - " + jrltabs.get(jrlID).getJrlFile().toPath().toString();
        ((Stage) scene.getWindow()).setTitle(titleName);
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
            jrltabs.get(jrlID).getJlrCodeArea().getUndoManager().mark();
            String titleName = "Juliar.Future - " + jrltabs.get(jrlID).getJrlFile().toPath().toString();
            ((Stage) scene.getWindow()).setTitle(titleName);
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
        ByteArrayOutputStream newOut = new ByteArrayOutputStream();
        ByteArrayOutputStream newErr = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(newOut);
        PrintStream ps2 = new PrintStream(newErr);
        // IMPORTANT: Save the old System.out!
        PrintStream oldOut = System.out;
        PrintStream oldErr = System.err;
        // Tell Java to use your special stream
        System.setOut(ps);
        System.setErr(ps2);
        // Print some output: goes to your special stream
        JuliarCompiler compiler = new JuliarCompiler();

        areaOutText.clear();
        areaErrorText.clear();
        areaOutText.appendText("Starting Interpreter at: " + LocalDateTime.now() + "\r\n");
        long startTime = System.nanoTime();
        CodeArea area = jrltabs.get(jrlID).getJlrCodeArea();
        InputStream is = new ByteArrayInputStream(area.getText().getBytes());

        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() {
                compilerRunning = true;
                compiler.compile(is, "/", false, false);
                return null;
            }
        };
        task.setOnSucceeded(taskFinishEvent -> {
            area.requestFocus();
            System.out.flush();
            System.setOut(oldOut);
            System.setErr(oldErr);
            areaErrorText.appendText(newErr.toString());
            areaOutText.appendText(newOut.toString());
            Pattern word = Pattern.compile("([0-9]+,[0-9]+).*\\r\\n");
            Matcher m = word.matcher(newErr.toString());

            if (m.find()) {
                tabPaneOut.getSelectionModel().select(1);
                String[] parts = m.group().split("[)] ");
                String[] indicators = parts[0].split(",");
                areaOutText.appendText(parts[1]);
                int startPos = area.getAbsolutePosition(Integer.parseInt(indicators[0])-1, Integer.parseInt(indicators[1]));
                int endPos = area.getAbsolutePosition(Integer.parseInt(indicators[0])-1, area.getParagraphLenth(Integer.parseInt(indicators[0])-1));
                area.selectRange(startPos, endPos);
                area.setEstimatedScrollY(0);
            } else {
                tabPaneOut.getSelectionModel().select(0);
            }

            while(m.find()){
                String[] parts = m.group().split("[)] ");
                areaOutText.appendText(parts[1]);
            }

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
        scene.getStylesheets().clear();
        CSSLoader.cssLoad(scene);
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
    public void onPackageManager() {
        try {
            Stage packageStage = new Stage();
            SceneCreator.create(packageStage,"packages.fxml","Juliar.Future Package Manager");
        }
        catch(Exception e){
            new GuiAlert(e,"Package Manager Cannot Launch");
        }

    }

    @FXML
    public void onWhatsNew(){ GuiInformation.create("What's New","Juliar New Features",
            "-Control + to increase size of text \r\n-Control - to decrease size of text \r\n-Control + Enter - Compile");}
}

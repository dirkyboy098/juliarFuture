package com.juliar.gui;

import com.juliar.errors.Logger;
import javafx.application.Platform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class Model {

    public void save(TextFile textFile) {
        try {
            Files.write(textFile.getFile(), textFile.getContent());
        } catch (IOException e) {
            Logger.log(e);
        }
    }

    public IOResult<TextFile> load(Path file) {
        try {
            List<String> lines = Files.readAllLines(file);
            return new IOResult<>(true, new TextFile(file, lines));
        } catch (IOException e) {
            Logger.log(e);
            return new IOResult<>(false, null);
        }
    }

    public void close() {
        Platform.exit();
    }
}
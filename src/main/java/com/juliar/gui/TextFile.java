package com.juliar.gui;

import java.nio.file.Path;
import java.util.List;

public class TextFile {

    private final Path file;

    private final List<String> content;

    private String name;

    TextFile(Path file, List<String> content) {
        this.file = file;
        this.content = content;
        this.name = file.getFileName().toString();
    }

    public Path getFile() {
        return file;
    }

    public List<String> getContent() {
        return content;
    }

    public String getName() { return name; }
}
package com.api.service;

import com.api.io.FileReader;
import com.api.io.FileWriter;

public class FileService {
    private final FileReader fileReader;
    private final FileWriter fileWriter;

    public FileService(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public String processFile() {
        return "Processed " + fileReader.read();
    }
}

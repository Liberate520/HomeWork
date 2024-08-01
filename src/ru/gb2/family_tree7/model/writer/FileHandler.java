package ru.gb2.family_tree7.model.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Writable {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write() {
        // Логика записи в файл
        try (FileWriter writer = new FileWriter(new File(filePath))) {
            // запись данных
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
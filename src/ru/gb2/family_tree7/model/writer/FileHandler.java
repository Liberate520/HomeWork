package ru.gb2.family_tree7.model.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Writable {
    @Override
    public void writeToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Запись данных в файл
            writer.write("Example content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
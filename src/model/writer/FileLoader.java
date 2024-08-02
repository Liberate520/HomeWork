package model.writer;

import java.io.*;

public class FileLoader {
    private String filePath;

    public FileLoader(String filePath) {
        this.filePath = filePath;
    }

    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {

            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}

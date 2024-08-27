package model.writer;

import java.io.*;

public class FileLoader implements LoaderInterface {
    private String filePath;

    public FileLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

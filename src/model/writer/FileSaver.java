package model.writer;

import java.io.*;
import java.io.Serializable;

public class FileSaver {
    private final String filePath;

    public FileSaver(String filePath) {
        this.filePath = filePath;
    }

    public boolean save (Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }
}

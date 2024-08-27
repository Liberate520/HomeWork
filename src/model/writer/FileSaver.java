package model.writer;

import java.io.*;

public class FileSaver implements SaverInterface {
    private final String filePath;

    public FileSaver(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(Serializable serializable) {
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

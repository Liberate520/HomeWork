package model.writer;

import java.io.*;

public class FileHandler implements Writer {
    @Override
    public void save(Serializable serializable, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(serializable);
        }
    }

    @Override
    public Serializable read(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Serializable) ois.readObject();
        }
    }
}

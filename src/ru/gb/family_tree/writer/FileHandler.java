package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean writeToFile(Serializable object) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(object);
            return true;
        }
    }

    @Override
    public Object readFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        }
    }

    @Override
    public void setPath(String path) {
        this.filePath = path;
    }
}

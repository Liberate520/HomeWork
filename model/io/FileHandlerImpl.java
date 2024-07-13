package model.io;

import java.io.*;

public class FileHandlerImpl implements FileHandler {
    @Override
    public <T> void writeToFile(String filename, T object) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(object);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (T) ois.readObject();
        }
    }
}

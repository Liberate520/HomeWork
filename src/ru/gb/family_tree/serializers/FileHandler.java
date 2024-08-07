package ru.gb.family_tree.serializers;

import java.io.*;

public class FileHandler<T> implements PersistenceHandler<T> {

    private String filename;

    public FileHandler(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    @Override
    public T readObject() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    @Override
    public void writeObject(T obj) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
        } catch (IOException ex) {
            throw ex;
        }
    }
}

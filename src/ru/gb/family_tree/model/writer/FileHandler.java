package ru.gb.family_tree.model.writer;

import java.io.*;

public class FileHandler implements Writer {

    static String filePath = "src/ru/gb/family_tree/model/writer/tree.txt";

    public FileHandler() {
        this.filePath = filePath;
    }

    @Override
    public boolean save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

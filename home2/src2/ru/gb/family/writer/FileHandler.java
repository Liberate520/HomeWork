package ru.gb.family.writer;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath =  "C:\\Users\\Татьяна\\IdeaProjects\\homeWork\\homeWork\\home2\\src2\\ru\\gb\\family\\writer/tree1.txt";
//"C:\\Users\\Татьяна\\IdeaProjects\\homeWork\\src/tree1.txt";

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}


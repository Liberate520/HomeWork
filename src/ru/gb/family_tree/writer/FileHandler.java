package ru.gb.family_tree.writer;

import java.io.*;


public class FileHandler implements Writer {


    private String path = "src/ru/gb/family_tree/writer/tree.txt";

    @Override
    public void write(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(serializable);
        objectOutputStream.close();
    }



    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        Object object = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setPath(String path){
        this.path = path;
    }
}
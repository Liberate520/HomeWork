package ru.gb.famaly_tree;

import java.io.*;

public class FileHandler implements Writable{

    @Override
    public void saved(Famaly_tree famalyTree) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("file");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(famalyTree);
        objectOutputStream.close();
    }

    @Override
    public Famaly_tree download() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("file");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        //objectInputStream.close();
        return (Famaly_tree) objectInputStream.readObject();
    }
}

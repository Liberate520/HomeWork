package ru.gb.famaly_tree.model.filehandler;

import ru.gb.famaly_tree.model.ft.Famaly_tree;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void saved(Famaly_tree famalyTree) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("file");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(famalyTree);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public Famaly_tree download() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("file");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Famaly_tree famalyTree = (Famaly_tree) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return famalyTree;
    }
}
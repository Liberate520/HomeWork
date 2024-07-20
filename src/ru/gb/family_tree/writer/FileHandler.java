package ru.gb.family_tree.writer;

import java.io.*;

public class FileHandler implements Writer{

    public FileHandler() {
    }

    @Override
    public void saveObject(Object obj, String objName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objName + ".out"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
    }

    @Override
    public Object readObject(String objName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objName + ".out"));
        Object obj = objectInputStream.readObject();
        objectInputStream.close();
        return obj;
    }
}

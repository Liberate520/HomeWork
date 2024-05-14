package model.writable;

import model.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable, Readable {
    String path = "src/model/writable/FamilyTree.txt";

    public FileHandler() {
    }

    @Override
    public void save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return new FamilyTree<>();
        }
    }

}

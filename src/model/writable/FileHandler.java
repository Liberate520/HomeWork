package model.writable;

import model.service.Service;

import java.io.*;

public class FileHandler implements Writable {
    Service service;

    public FileHandler() {
        service = new Service();
    }

    @Override
    public void save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/model/writable/FamilyTree.txt"));
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/model/writable/FamilyTree.txt"));
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

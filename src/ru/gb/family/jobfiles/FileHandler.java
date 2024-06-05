package ru.gb.family.jobfiles;

import ru.gb.family.familyTree.FamilyTree;
import ru.gb.family.service.Service;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public boolean save (Serializable serializable, String filePath) {
        try {ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));

            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Object read(String pathFile) {
        Service service = new Service();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathFile));
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            //throw new RuntimeException(e);
            return Service.newFamilyTree();
        }

    }

    @Override
    public boolean chekFile(String filePath) {
        File file = new File(filePath);
        return (file.exists() && !file.isDirectory());
    }
}

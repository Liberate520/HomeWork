package ru.gb.family;

import java.io.*;

public class FileHandler implements  Writable {
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
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathFile));
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);

        }

    }
}

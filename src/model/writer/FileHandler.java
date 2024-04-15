package model.writer;

import java.io.*;

public class FileHandler implements Writable {

    public void save(Serializable serializable, String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(serializable);
            System.out.println("File " + fileName + " has been created\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object read(String fileName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            System.out.println("File " + fileName + " has been loaded\n");
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
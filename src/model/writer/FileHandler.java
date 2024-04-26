package model.writer;

import java.io.*;

public class FileHandler implements Writable {
    private final String fileName = "src/model/writer/BackUp.txt";

    public String save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(serializable);
            return "File " + fileName + " has been created\n";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
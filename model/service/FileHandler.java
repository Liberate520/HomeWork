package homeWork.model.service;

import java.io.*;

public class FileHandler implements Writable {
    public void writeFile(Serializable serializable, String filename) {
        try(ObjectOutputStream objectOutputStream  = new ObjectOutputStream(new FileOutputStream(filename))){
            objectOutputStream .writeObject(serializable);
            objectOutputStream.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public Object readFile(String filename) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object list = objectInputStream.readObject();
            objectInputStream.close();
            return list;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
}

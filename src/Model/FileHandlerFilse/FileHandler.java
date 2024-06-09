package Model.FileHandlerFilse;

import java.io.*;

public class FileHandler<T> implements Writable<T> {
    public void save(T t, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(t);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void load(String Path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Path))){
            objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

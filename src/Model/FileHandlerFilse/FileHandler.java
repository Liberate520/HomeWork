package Model.FileHandlerFilse;

import java.io.*;

public class FileHandler<T> implements Writable<T> {
    private String path = "homeWork.out";

    public void changePath(String path) {
        this.path = path;
    }
    public void save(T t) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path))){
            objectOutputStream.writeObject(t);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))){
            objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

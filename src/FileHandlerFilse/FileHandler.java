package FileHandlerFilse;

import java.io.*;

public class FileHandler implements Writable {
    public void save(Object familyTree, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(familyTree);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public Object load(String Path) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(Path))){
            return objectInputStream.readObject();
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

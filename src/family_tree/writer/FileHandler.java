package family_tree.writer;

import java.io.*;

public class FileHandler implements Writable{
    public boolean save(Serializable serializable, String FilePath){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FilePath))){
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Object read(String FilePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FilePath))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}

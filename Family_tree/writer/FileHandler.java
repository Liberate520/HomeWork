package Family_tree.writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileHandler implements Writer{
    private String filePath = "src/Family_tree/writer/result.txt";

    @Override
    public void save(Serializable serializable){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            // return e.printStackTrace();
        }
    }

    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            // return e.printStackTrace();
            return null;
        }
    }

    public void setPath(String filePath){
        this.filePath = filePath;
    }
}

package writer;

import java.io.*;

public class FileHandler implements Writer {

    private String filePath = "src/writer/tree.txt";

    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPath(String filePath) {
        this.filePath = filePath;
    }

}

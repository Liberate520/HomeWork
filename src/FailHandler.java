import java.io.*;

public class FailHandler implements Writable {


    public boolean save(Serializable serializable, String filePath) {
        try
                (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try (ObjectInputStream objectInputStreamStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return objectInputStreamStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

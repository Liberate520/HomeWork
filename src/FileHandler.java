import java.io.*;

public class FileHandler implements Writable{
    @Override
public boolean save(Serializable serializable, String filePath) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
        oos.writeObject(serializable);
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}

    @Override
    public Object read(String filePath) { 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
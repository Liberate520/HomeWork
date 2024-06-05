package family_tree;

import java.io.*;

public class FileHandler implements WriteRead {
    @Override
    public boolean save(Serializable serializable, String pathName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathName))) {
            objectOutputStream.writeObject(serializable);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String pathName) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName))) {
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
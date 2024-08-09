package family_tree.model.writer;

import java.io.*;

public class FileHandler implements Writer {
    private String filePath = "person.out";

    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object object = objectInputStream.readObject();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void clear() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPath(String filePath) {
        this.filePath = filePath;
    }

}

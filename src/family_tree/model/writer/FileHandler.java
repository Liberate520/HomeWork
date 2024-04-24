package family_tree.model.writer;

import java.io.*;

public class FileHandler implements Writable<Serializable> {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(Serializable object) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.filePath))) {
            oos.writeObject(object);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Serializable read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.filePath))) {
            return (Serializable) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
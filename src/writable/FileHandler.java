package writable;

import java.io.*;

public class FileHandler implements Writable {
    @Override
    public void save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/writable/FamilyTree.txt"));
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/writable/FamilyTree.txt"));
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

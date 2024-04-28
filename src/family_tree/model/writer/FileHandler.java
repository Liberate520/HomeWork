package family_tree.model.writer;

import java.io.*;

public class FileHandler implements Writer {
    public static final String filePath = "src/family_tree/model/writer/tree";
    @Override
    public boolean write(Serializable sr) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(sr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

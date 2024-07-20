package Writer;

import FamilyTree.FamilyTree;
import java.io.*;

public class FamilyTreeFileHandler implements Writer {
    private String path;

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void save(FamilyTree<?> tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree<?> read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (FamilyTree<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

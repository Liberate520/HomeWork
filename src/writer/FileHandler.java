package writer;

import family_tree.FamilyTree;
import family_tree.FamilyTreeItem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler<T extends FamilyTreeItem> implements MyWriter<T> {
    private String storage = "data.txt";

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public boolean save(FamilyTree<T> familyTree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(storage))) {
            objectOutputStream.writeObject(familyTree);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FamilyTree<T> load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(storage))) {
            return (FamilyTree<T>) objectInputStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}

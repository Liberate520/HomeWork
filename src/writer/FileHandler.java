package writer;

import family_tree.FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler implements MyWriter {
    private String storage = "data.txt";

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public boolean save(FamilyTree familyTree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(storage))) {
            objectOutputStream.writeObject(familyTree);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public FamilyTree load() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(storage))) {
            return (FamilyTree) objectInputStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}

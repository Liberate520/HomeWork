package writer;

import family_tree.FamilyTree;
import human.Human;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileHandler implements MyWriter {
    private String storage = "data.txt";

    public void setStorage(String storage) {
        this.storage = storage;
    }

    @Override
    public boolean save(FamilyTree familyTree) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(storage))) {
            objectOutputStream.writeObject(familyTree.getFamilyTree());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean load(FamilyTree familyTree) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(storage))) {
            familyTree.setFamilyTree((List<Human>) objectInputStream.readObject());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

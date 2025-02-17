package GB_Homework.Model.Service;

import GB_Homework.Model.Family_Tree.FamilyTree;
import GB_Homework.Model.Handler.Writable;
import GB_Homework.Model.Human.Human;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileService {
    private Writable writable;

    public FileService(Writable writable) {
        this.writable = writable;
    }

    public void saveFamilyTree(FamilyTree<Human> familyTree, String file) throws IOException {
        writable.save(familyTree, file);
    }

    public FamilyTree<Human> readFamilyTree(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        FamilyTree<Human> loadedTree = (FamilyTree<Human>) ois.readObject();
        ois.close();
        return loadedTree;
    }
}

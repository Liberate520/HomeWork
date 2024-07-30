package Writer;
import FamillyTree.FamilyTree;

import java.io.*;

public class FileOperations  {
    private FamilyTree familyTree;

    public FileOperations(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

   public void save(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    public void load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            familyTree = (FamilyTree) ois.readObject();
        }
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
}
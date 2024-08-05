package Model.Writer;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.FamilyTreeItem;
import Model.Human.Human;

import java.io.*;

public class FileHandler implements Writer {
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void saveToFile(String filename, FamilyTree familyTree) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree readFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree = (FamilyTree) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return familyTree;
    }
}

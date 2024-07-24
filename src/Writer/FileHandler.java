package Writer;

import FamilyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void saveToFile(FamilyTree familyTree) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("familyTree.ser"))) {
            objectOutputStream.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("familyTree.ser"));) {
            familyTree = (FamilyTree) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return familyTree;
    }
}

import java.io.*;

public class FileHandler implements Writer{
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public void loadFromFile(String fileName) throws ClassNotFoundException, IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            this.familyTree = (FamilyTree) ois.readObject();
        }
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }
}

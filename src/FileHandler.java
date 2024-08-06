import java.io.*;

public class FileHandler<T extends FamilyMember> implements Writer<T> {

    @Override
    public void saveFamilyTree(FamilyTree<T> familyTree, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> loadFamilyTree(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}
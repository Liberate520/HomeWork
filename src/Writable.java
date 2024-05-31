import java.io.*;

public interface Writable {
    default void save(FamilyTree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familytree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    default FamilyTree load() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familytree.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}

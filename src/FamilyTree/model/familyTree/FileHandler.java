package FamilyTree.model.familyTree;

import java.io.*;

public class FileHandler implements Writable {

    public void save(FamilyTree familyTree, String filePatch) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePatch));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree load(String filePatch) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePatch));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}


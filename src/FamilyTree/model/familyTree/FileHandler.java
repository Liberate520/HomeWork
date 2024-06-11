package FamilyTree.model.familyTree;

import FamilyTree.model.element.ElementFamilyTree;

import java.io.*;

public class FileHandler<E extends ElementFamilyTree<E>> implements Writable<E> {

    public void save(FamilyTree<E> familyTree, String filePatch) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(filePatch));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree<E> load(String filePatch) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePatch));
        FamilyTree<E> familyTree = (FamilyTree<E>) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}


package model.family_tree.writer;

import model.family_tree.instances.Human;
import model.family_tree.tree.FamilyTree;

import java.io.*;


public class FileHandler implements Writable<Human>, Serializable {
    @Override
    public void writeToFamilyTree(FamilyTree<Human> familyTree, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    @Override
    public FamilyTree<Human> readFromFamilyTree(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        return (FamilyTree<Human>) objectInputStream.readObject();
    }
}

package model.family_tree.writer;

import model.family_tree.tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable, Serializable {
    @Override
    public void writeToFamilyTree(FamilyTree familyTree, String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    @Override
    public FamilyTree readFromFamilyTree(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        return (FamilyTree)objectInputStream.readObject();
    }
}

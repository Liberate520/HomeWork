package model.family_tree.writer;

import model.family_tree.instances.Human;
import model.family_tree.tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable<Human>, Serializable {

    private String path;
    public FileHandler(String path){
        this.path = path;
    }

    @Override
    public void writeToFamilyTree(FamilyTree<Human> familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    @Override
    public FamilyTree<Human> readFromFamilyTree() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(path));
        return (FamilyTree<Human>) objectInputStream.readObject();
    }
}

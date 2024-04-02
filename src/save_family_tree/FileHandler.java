package src.save_family_tree;

import src.family_tree.FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FileHandler implements Writable {
    private static final String FILE_NAME = "myTree.out";
    private static final String FILE_PATH = "src/save_family_tree/";

    @Override
    public void saveTree(Writable tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH + FILE_NAME));
        objectOutputStream.writeObject(tree);
        try {
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Writable loadTree() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(FILE_PATH + FILE_NAME));
        Writable tree = (FamilyTree) objectInputStream.readObject();
        try {
            objectInputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tree;
    }
}
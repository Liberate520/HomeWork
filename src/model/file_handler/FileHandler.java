package model.file_handler;

import model.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements model.file_handler.Writable {

    @Override
    public void saveTree(FamilyTree familyTree) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("C:\\SavedTree.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree downloadTree() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("C:\\SavedTree.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
}
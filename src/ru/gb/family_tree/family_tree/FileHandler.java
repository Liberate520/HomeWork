package ru.gb.family_tree.family_tree;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void saveFileByte(FamilyTree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("family.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    public FamilyTree loadFileByte() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream("family.out")));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        return familyTree;
    }
}

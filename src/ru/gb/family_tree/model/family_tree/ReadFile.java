package ru.gb.family_tree.model.family_tree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadFile implements Readable{
    public FamilyTree loadFileByte() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream((new FileInputStream("family.out")));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;

    }
}

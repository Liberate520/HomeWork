package ru.gb.FamilyTree;

import java.io.IOException;
import java.io.*;

public class FamilyTreeSerializer implements Serializer<FamilyTree>{

    @Override
    public void serializer(FamilyTree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }

    @Override
    public FamilyTree deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        return familyTree;
    }
}

package ru.gb.FamilyTree;

import java.io.*;
import java.nio.channels.WritableByteChannel;

public  class FileHandler implements Writable {
    @Override
    public void saveFileByte(ru.gb.FamilyTree.FamilyTree familyTree) throws IOException {
        ObjectOutputStream  objectOutputStream = new ObjectOutputStream
                (new FileOutputStream("family.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
    public FamilyTree loadFileBite() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream
                (new FileInputStream("family.out"));
        FamilyTree familyTree =(FamilyTree) objectInputStream.readObject();
        return familyTree;
    }
}

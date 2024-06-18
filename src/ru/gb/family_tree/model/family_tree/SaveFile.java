package ru.gb.family_tree.model.family_tree;

import java.io.*;

public class SaveFile implements Writable {

    @Override
    public void saveFileByte(Tree familyTree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("family.out"));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
}

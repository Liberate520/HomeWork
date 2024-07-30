package ru.gb.family_tree.writer;

import ru.gb.family_tree.tree.FamilyTree;

import java.io.*;

public class FileHendler implements Writer{

     public void serializationToFile(FamilyTree tree) {

            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream("human.out"));
                objectOutputStream.writeObject(tree);
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public FamilyTree restoringFromFile() {
        FamilyTree tree = new FamilyTree();

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("human.out"));
            tree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tree;
        }

}

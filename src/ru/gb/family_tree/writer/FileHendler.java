package ru.gb.family_tree.writer;

import ru.gb.family_tree.model.tree.FamilyTree;

import java.io.*;

public class FileHendler implements Writer{
    private String filePath;

    public FileHendler(String filePath) {
        this.filePath = filePath;
    }

    @Override
     public void serializationToFile(FamilyTree tree) {

            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
                objectOutputStream.writeObject(tree);
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }


    @Override
    public FamilyTree restoringFromFile() {
        FamilyTree tree = new FamilyTree();

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            tree = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tree;
        }

    @Override
    public void setPath(String path) {
        this.filePath = path;
    }

}

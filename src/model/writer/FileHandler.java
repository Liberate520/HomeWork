package model.writer;

import java.io.*;

import model.tree.FamilyTree;

public class FileHandler implements Writable {
    private String filePath = "person.out";

    public FileHandler() {
    }

    @Override
    public boolean save(FamilyTree tree) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            objectOutputStream.writeObject(tree);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public FamilyTree load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(filePath))) {

            // Считываем объект FamilyTree из файла
            FamilyTree loadedTree = (FamilyTree) objectInputStream.readObject();

            return loadedTree;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}

package io;

import model.FamilyTree;

import java.io.*;

public class FileHandlerImpl implements FileHandler, Writer {
    @Override
    public void saveFamilyTree(FamilyTree tree, String filename) {
        writeToFile(filename, tree);
    }

    @Override
    public FamilyTree loadFamilyTree(String filename) {
        return (FamilyTree) readFromFile(filename);
    }

    @Override
    public void writeToFile(String filename, Object obj) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object readFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

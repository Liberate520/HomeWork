package io;

import model.FamilyTree;

import java.io.*;

public class TreeIOImpl implements TreeIO {
    @Override
    public void saveToFile(FamilyTree tree, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tree);
        }
    }

    @Override
    public FamilyTree loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) ois.readObject();
        }
    }
}

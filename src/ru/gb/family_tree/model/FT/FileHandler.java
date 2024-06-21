package ru.gb.family_tree.model.FT;

import java.io.*;

public class FileHandler implements Writable {
    public void saveFamilyTree(FamilyTree familyTree, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(familyTree);
        }
    }

    public FamilyTree loadFamilyTree(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree) ois.readObject();
        }
    }
}

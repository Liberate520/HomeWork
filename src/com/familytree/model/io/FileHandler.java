

package com.familytree.model.io;

import com.familytree.model.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writeable {
    private final String filePath;

    public FileHandler(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeToFile(FamilyTree familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree) ois.readObject();
        }
    }
}


package com.familytree.model.io;

import com.familytree.model.family_tree.FamilyTree;
import com.familytree.model.human.Human;

import java.io.*;

public class FileHandler implements Writeable {

    @Override
    public <T extends Serializable> void writeToFile(FamilyTree<Human> familyTree, String filePath) throws IOException {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs(); // Создаем папки, если они не существуют
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(familyTree);
        }
    }



    @Override
    public <T extends Serializable> FamilyTree<Human> readFromFile(String filePath) throws IOException, ClassNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            return new FamilyTree<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (FamilyTree<Human>) ois.readObject();
        }
    }
}

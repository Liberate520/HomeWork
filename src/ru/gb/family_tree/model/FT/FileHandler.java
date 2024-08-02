package ru.gb.family_tree.model.FT;

import ru.gb.family_tree.model.Human.Human;
import ru.gb.family_tree.model.builder.HumanBuilder;

import java.io.*;

public class FileHandler<T extends FamilyTreeItem<T>>  implements Writable {
    public void saveFamilyTree(FamilyTree familyTree, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(familyTree);
        }
    }

    public FamilyTree<T> loadFamilyTree(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }

}

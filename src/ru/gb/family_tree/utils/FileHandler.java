package ru.gb.family_tree.utils;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.interfaces.HasRelations;

import java.io.*;

@SuppressWarnings("ALL")
public class FileHandler<T extends Serializable & HasRelations<T>> {

    @SuppressWarnings("CallToPrintStackTrace")
    public void saveFamilyTree(FamilyTree<T> familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public FamilyTree<T> loadFamilyTree(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

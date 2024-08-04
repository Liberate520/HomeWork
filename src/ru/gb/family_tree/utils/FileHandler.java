package ru.gb.family_tree.utils;

import ru.gb.family_tree.FamilyTree;

import java.io.*;

public class FileHandler<T extends Serializable> {

    public void saveFamilyTree(FamilyTree<T> familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        } catch (IOException e) {
            System.err.println("Error saving family tree: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public FamilyTree<T> loadFamilyTree(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) ois.readObject();
        } catch (IOException e) {
            System.err.println("Error loading family tree: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
        return null;
    }
}

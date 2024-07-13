package com.familytree.utils;

import com.familytree.FamilyTree;
import com.familytree.model.FamilyMember;

import java.io.*;

public class FamilyTreeSerializer {

    public static <T extends Serializable & FamilyMember<T>> void saveToFile(FamilyTree<T> familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
            System.out.println("Family tree has been saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Serializable & FamilyMember<T>> FamilyTree<T> loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

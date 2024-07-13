package com.familytree.utils;

import com.familytree.FamilyTree;

import java.io.*;

public class FamilyTreeSerializer {

    // Метод для записи FamilyTree в файл
    public static void saveToFile(FamilyTree familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
            System.out.println("Family tree has been saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения FamilyTree из файла
    public static FamilyTree loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

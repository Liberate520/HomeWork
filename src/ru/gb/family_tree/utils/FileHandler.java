package ru.gb.family_tree.utils;

import ru.gb.family_tree.FamilyTree;

import java.io.*;

// Класс для работы с файлами, обеспечивающий сохранение и загрузку семейного дерева
public class FileHandler {

    // Метод для сохранения семейного дерева в файл
    public void saveFamilyTree(FamilyTree familyTree, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для загрузки семейного дерева из файла
    public FamilyTree loadFamilyTree(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package ru.gb.family_tree.writer;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.service.FamilyTreeItem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler<T extends FamilyTreeItem<T>> implements Writer<T> {
    public void saveToFile(List<T> list, String string) {
        FileOutputStream output = null;
        ObjectOutputStream objectOutputStream;
        try {
            output = new FileOutputStream(string);
        } catch (Exception e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveToFile(FamilyTree<T> familyTree, String string) {
        FileOutputStream output = null;
        ObjectOutputStream objectOutputStream;
        try {
            output = new FileOutputStream(string);
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(familyTree);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<T> restoreFromFileH (String string) {
        FileInputStream input = null;
        ObjectInputStream objectInputStream;
        List<T> result = new ArrayList<>();
        try {
            input = new FileInputStream(string);
        } catch (Exception e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectInputStream = new ObjectInputStream(input);
            result = (List<T>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public FamilyTree<T> restoreFromFileFT (String string) {
        FileInputStream input = null;
        ObjectInputStream objectInputStream;
        FamilyTree<T> result = new FamilyTree<>();
        try {
            input = new FileInputStream(string);
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectInputStream = new ObjectInputStream(input);
            result = (FamilyTree<T>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

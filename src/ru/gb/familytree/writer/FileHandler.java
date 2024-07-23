package ru.gb.familytree.writer;

import ru.gb.familytree.family_tree.FamilyTree;
import ru.gb.familytree.human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Writer {
    public void saveToFile(List<Human> list, String string) {
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

    public void saveToFile(FamilyTree familyTree, String string) {
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

    public List<Human> restoreFromFileH (String string) {
        FileInputStream input = null;
        ObjectInputStream objectInputStream;
        List<Human> result = new ArrayList<>();
        try {
            input = new FileInputStream(string);
        } catch (Exception e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectInputStream = new ObjectInputStream(input);
            result = (List<Human>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public FamilyTree restoreFromFileFT (String string) {
        FileInputStream input = null;
        ObjectInputStream objectInputStream;
        FamilyTree result = new FamilyTree();
        try {
            input = new FileInputStream(string);
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectInputStream = new ObjectInputStream(input);
            result = (FamilyTree) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

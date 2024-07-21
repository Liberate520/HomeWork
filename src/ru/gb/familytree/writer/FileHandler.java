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
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectOutputStream = new ObjectOutputStream(output);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("1");
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
            System.out.println("1");
        }
    }

    public List<Human> restoreFromFileH (String string) {
        FileInputStream input = null;
        ObjectInputStream objectInputStream;
        List<Human> result = new ArrayList<>();
        try {
            input = new FileInputStream(string);
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
        try {
            objectInputStream = new ObjectInputStream(input);
            result = (List<Human>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println("2");
        } catch (ClassNotFoundException e) {
            System.out.println("3");
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
        } catch (IOException e) {
            System.out.println("2");
        } catch (ClassNotFoundException e) {
            System.out.println("3");
        }
        return result;
    }
}

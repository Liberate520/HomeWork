package com.example.familytree.operations;

import com.example.familytree.FamilyTree;
import com.example.familytree.model.Person;

import java.io.*;

public class FileFamilyTreeOperations implements FileOperations {
    @Override
    public void saveToFile(String filename, FamilyTree<Person> tree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(tree);
            System.out.println("Дерево сохранено в файл: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree<Person> loadFromFile(String filename) {
        FamilyTree<Person> tree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            tree = (FamilyTree<Person>) ois.readObject();
            System.out.println("Дерево загружено из файла: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tree;
    }
}

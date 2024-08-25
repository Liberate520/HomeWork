package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.*;

public class FileService {
    public void saveToFile(FamilyTree<Person> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    public FamilyTree<Person> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<Person>) ois.readObject();
        }
    }
}
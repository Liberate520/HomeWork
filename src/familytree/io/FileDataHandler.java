package familytree.io;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.*;

public class FileDataHandler implements DataHandler {

    @Override
    public void saveToFile(String filename, FamilyTree<Person> familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<Person> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree<Person>) ois.readObject();
        }
    }
}
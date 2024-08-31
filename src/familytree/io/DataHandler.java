package familytree.io;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.IOException;

public interface DataHandler {
    void saveToFile(String filename, FamilyTree<Person> familyTree) throws IOException;
    FamilyTree<Person> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
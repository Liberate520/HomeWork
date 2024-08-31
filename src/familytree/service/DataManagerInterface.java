package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.IOException;

public interface DataManagerInterface {
    void saveToFile(String filename) throws IOException;
    FamilyTree<Person> loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
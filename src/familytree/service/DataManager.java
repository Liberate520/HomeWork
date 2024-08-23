package familytree.service;

import familytree.io.DataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;

import java.io.IOException;

public class DataManager implements DataManagerInterface{
    private FamilyTree<Person> familyTree;
    private final DataHandler dataHandler;


    public DataManager(DataHandler dataHandler, FamilyTree<Person> familyTree) {
        this.dataHandler = dataHandler;
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        dataHandler.saveToFile(filename, familyTree);
    }

    @Override
    public FamilyTree<Person> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        familyTree = dataHandler.loadFromFile(filename);
        return familyTree;
    }

    public FamilyTree<Person> getFamilyTree() {
        return familyTree;
    }
}
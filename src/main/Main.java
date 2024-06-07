package main;

import model.FamilyTree;
import model.Person;
import storage.DataStorage;
import storage.FileDataStorage;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();

        DataStorage storage = new FileDataStorage();
        try {
            List<Person> loadedMembers = storage.loadFromFile("family_tree.dat");
            familyTree.setMembers(loadedMembers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CommandProcessor commandProcessor = new CommandProcessor(familyTree);
        commandProcessor.start();

        try {
            storage.saveToFile("family_tree.dat", familyTree.getMembers());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

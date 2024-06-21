package service;

import model.FamilyTree;
import model.Person;
import storage.DataLoader;
import storage.DataSaver;

import java.io.IOException;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Person> familyTree;
    private DataLoader dataLoader;
    private DataSaver dataSaver;

    public FamilyTreeService(DataLoader dataLoader, DataSaver dataSaver) {
        this.familyTree = new FamilyTree<>();
        this.dataLoader = dataLoader;
        this.dataSaver = dataSaver;
    }

    public void addMember(Person person) {
        familyTree.addMember(person);
    }

    public Person findPersonByName(String name) {
        for (Person person : familyTree.getMembers()) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getChildrenOf(Person parent) {
        return parent.getChildren();
    }

    public List<Person> loadFamilyTree() throws IOException {
        List<Person> loadedMembers = dataLoader.loadData();
        familyTree.setMembers(loadedMembers);
        return loadedMembers;
    }

    public void saveFamilyTree() throws IOException {
        dataSaver.saveData(familyTree.getMembers());
    }
}











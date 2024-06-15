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
        return familyTree.findPersonByName(name);
    }

    public List<Person> getChildrenOf(Person parent) {
        return familyTree.getChildrenOf(parent);
    }

    public List<Person> loadFamilyTree() throws IOException {
        return dataLoader.loadData();
    }

    public void saveFamilyTree() throws IOException {
        dataSaver.saveData(familyTree.getMembers());
    }
}










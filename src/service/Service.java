package service;

import familytree.FamilyTree;
import person.Person;
import person.Gender;
import writer.TreeStorage;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Person> familyTree;
    private TreeStorage<Person> storage;

    public Service(FamilyTree<Person> familyTree, TreeStorage<Person> storage) {
        this.familyTree = familyTree;
        this.storage = storage;
    }

    public void addPerson(String name, LocalDate birthDate, LocalDate deathDate, String genderStr) {
        Person person = new Person(name, birthDate, deathDate, Gender.valueOf(genderStr.toUpperCase()));
        familyTree.addMember(person);
    }

    public Person findPerson(String name) {
        return familyTree.findMemberByName(name);
    }

    public String getAllMembers() {
        return familyTree.getMembers().toString();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void saveTree(String fileName) {
        storage.save(familyTree, fileName);
    }

    public void loadTree(String fileName) {
        FamilyTree<Person> loadedTree = storage.load(fileName);
        if (loadedTree != null) {
            this.familyTree = loadedTree;
        }
    }

    public void addRelation(String parentName, String childName) {
        Person parent = findPerson(parentName);
        Person child = findPerson(childName);
        if (parent != null && child != null) {
            familyTree.addParentChildRelation(parent, child);
        }
    }
}

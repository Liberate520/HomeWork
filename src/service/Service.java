package service;

import familytree.FamilyTree;
import person.Person;
import person.Gender;
import writer.TreeStorage;

import java.time.LocalDate;

public class Service {
    private FamilyTree<Person> familyTree;
    private TreeSorter<Person> sorter;
    private TreeStorage<Person> storage;

    public Service(FamilyTree<Person> familyTree, TreeSorter<Person> sorter, TreeStorage<Person> storage) {
        this.familyTree = familyTree;
        this.sorter = sorter;
        this.storage = storage;
    }

    public void addPerson(String name, LocalDate birthDate, LocalDate deathDate, String genderStr) {
        PersonBuilder personBuilder = new PersonBuilder();
        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        Person person = personBuilder
                .setName(name)
                .setBirthDate(birthDate)
                .setDeathDate(deathDate)
                .setGender(gender)
                .build();
        familyTree.addMember(person);
    }

    public Person findPerson(String name) {
        return familyTree.findMemberByName(name);
    }

    public String getAllMembers() {
        return familyTree.getMembers().toString();
    }

    public void sortByName() {
        sorter.sortByName(familyTree.getMembers());
    }

    public void sortByBirthDate() {
        sorter.sortByBirthDate(familyTree.getMembers());
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
}

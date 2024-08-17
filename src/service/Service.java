package service;

import familytree.FamilyTree;
import person.Person;
import person.Gender;
import writer.TreeStorage;

import java.time.LocalDate;
import java.util.List;

public class Service {
    private FamilyTree<Person> familyTree;
    private TreeStorage<Person> treeStorage;

    public Service(FamilyTree<Person> familyTree, TreeStorage<Person> treeStorage) {
        this.familyTree = familyTree;
        this.treeStorage = treeStorage;
    }

    public void addPerson(String name, LocalDate birthDate, LocalDate deathDate, String genderStr,
                          String spouseName, List<String> childrenNames, String fatherName, String motherName) {
        Gender gender = Gender.valueOf(genderStr.toUpperCase());
        Person person = new Person(name, birthDate, deathDate, gender);
        familyTree.addPerson(person);

        if (spouseName != null) {
            Person spouse = familyTree.findPerson(spouseName);
            if (spouse != null) {
                person.setSpouse(spouse);
                spouse.setSpouse(person);
            }
        }

        for (String childName : childrenNames) {
            Person child = familyTree.findPerson(childName);
            if (child != null) {
                person.addChild(child);
                child.addParent(person);
            }
        }

        if (fatherName != null) {
            Person father = familyTree.findPerson(fatherName);
            if (father != null) {
                person.addParent(father);
                father.addChild(person);
            }
        }

        if (motherName != null) {
            Person mother = familyTree.findPerson(motherName);
            if (mother != null) {
                person.addParent(mother);
                mother.addChild(person);
            }
        }
    }

    public Person findPerson(String name) {
        return familyTree.findPerson(name);
    }

    public List<Person> getAllPersons() {
        return familyTree.getAllPersons();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void saveTree(String fileName) {
        treeStorage.save(familyTree, fileName);
    }

    public void loadTree(String fileName) {
        FamilyTree<Person> loadedTree = treeStorage.load(fileName);
        if (loadedTree != null) {
            this.familyTree = loadedTree;
        }
    }

    public boolean addRelation(String parentName, String childName) {
        Person parent = familyTree.findPerson(parentName);
        Person child = familyTree.findPerson(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
            return true;
        }
        return false;
    }
}


package Service;

import Model.FamilyTree;
import Model.Person;
import Util.FileManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class FamilyTreeService {
    private final FamilyTree<Person> familyTree;
    private final FileManager fileManager;

    public FamilyTreeService(FamilyTree<Person> familyTree, FileManager fileManager) {
        this.familyTree = familyTree;
        this.fileManager = fileManager;
    }

    public void addPerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate, Person.Gender gender) {
        Person person = new Person(firstName, lastName, birthDate, deathDate, gender);
        familyTree.addPerson(person);
    }

    public void setParents(int childId, int motherId, int fatherId) {
        familyTree.setParents(childId, motherId, fatherId);
    }
    public List<Person> getAllPeople(int sortChoice) {
        if (sortChoice == 1) {
            familyTree.sort();
        } else if (sortChoice == 2) {
            familyTree.sortByBirthDate();
        }
        return familyTree.getAllPeople();
    }

    public Person findById(int id) {
        return familyTree.getPerson(id);
    }

    public List<Person> findByName(String firstName, String lastName) {
        return familyTree.findByName(firstName, lastName);
    }

    public void saveTree(String filename) {
        fileManager.saveFamilyTree(familyTree, filename);
    }

    public void loadTree(String filename) {
        FamilyTree<Person> loadedTree = (FamilyTree<Person>) fileManager.loadFamilyTree(filename);
        if (loadedTree != null) {
            familyTree.getAllPeople().clear();
            familyTree.getAllPeople().addAll(loadedTree.getAllPeople());
        }
    }

    public FamilyTree<Person> getFamilyTree() {
        return familyTree;
    }
    public void getChildren(int personId) {
        familyTree.getChildren(personId);
    }

    public void getParents(int personId) {
        familyTree.getParents(personId);
    }
}

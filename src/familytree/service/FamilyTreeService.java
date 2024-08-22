package familytree.service;

import familytree.factory.PersonFactory;
import familytree.io.DataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.model.FullName;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    private FamilyTree<Person> familyTree;
    private final DataHandler dataHandler;
    private final PersonFactory personFactory;

    public FamilyTreeService(FamilyTree<Person> familyTree, DataHandler dataHandler,PersonFactory personFactory) {
        this.familyTree = familyTree;
        this.dataHandler = dataHandler;
        this.personFactory = personFactory;
    }

    public void addMember(String familyName, String firstName, String fatherName, Person.Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Person newMember = personFactory.createPerson(familyName, firstName, fatherName, gender, dateOfBirth, dateOfDeath);
        familyTree.addMember(newMember);
    }

    public Person findMember(String familyName, String firstName, String fatherName) {
        return familyTree.findMemberByFullName(familyName, firstName, fatherName);
    }

    public void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                           String childFamilyName, String childFirstName, String childFatherName) {
        familyTree.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
    }

    public List<Person> getSortedByName() {
        return familyTree.getSortedByName();
    }

    public List<Person> getSortedByDateOfBirth() {
        return familyTree.getSortedByDateOfBirth();
    }

    public void saveToFile(String filename) throws IOException {
        dataHandler.saveToFile(filename, familyTree);
    }

    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        familyTree = dataHandler.loadFromFile(filename);
    }

    public FamilyTree<Person> getFamilyTree() {
        return familyTree;
    }

    public Person createPerson(String familyName, String firstName, String fatherName, Person.Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        return new Person(new FullName(familyName, firstName, fatherName), gender, dateOfBirth, dateOfDeath);
    }

    public void addMember(Person newMember) {
    }
}
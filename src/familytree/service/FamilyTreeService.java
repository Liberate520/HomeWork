package familytree.service;

import familytree.model.Person;
import familytree.model.FullName;
import familytree.model.FamilyTree;
import familytree.ui.ConsoleUserInterface;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService implements FamilyTreeServiceInterface {
    private final MemberManagerInterface memberManager;
    private final RelationshipManagerInterface relationshipManager;
    private final DataManagerInterface dataManager;


    public FamilyTreeService(MemberManagerInterface memberManager,
                             RelationshipManagerInterface relationshipManager,
                             DataManagerInterface dataManager
    ) {
        this.memberManager = memberManager;
        this.relationshipManager = relationshipManager;
        this.dataManager = dataManager;
    }

    @Override
    public void addMember(String familyName, String firstName, String fatherName, Person.Gender gender,
                          LocalDate dateOfBirth, LocalDate dateOfDeath) {

        FullName fullName = new FullName(familyName, firstName, fatherName);
        Person newMember = new Person(fullName, gender, dateOfBirth, dateOfDeath);

        memberManager.addMember(newMember);
    }

    @Override
    public Person findMember(String familyName, String firstName, String fatherName) {
        return memberManager.findMember(familyName, firstName, fatherName);
    }

    @Override
    public void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                           String childFamilyName, String childFirstName, String childFatherName) {
        relationshipManager.addParentChildRelationship(parentFamilyName, parentFirstName, parentFatherName,
                childFamilyName, childFirstName, childFatherName);
    }

    @Override
    public List<Person> getSortedByName() {
        return memberManager.getSortedByName();
    }

    @Override
    public List<Person> getSortedByDateOfBirth() {
        return memberManager.getSortedByDateOfBirth();
    }

    @Override
    public void saveToFile(String filename) throws IOException {
        dataManager.saveToFile(filename);
    }

    @Override
    public FamilyTree<Person> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        FamilyTree<Person> familyTree = dataManager.loadFromFile(filename);
        memberManager.updateFamilyTree(familyTree);
        relationshipManager.updateFamilyTree(familyTree);
        return familyTree;
    }
}
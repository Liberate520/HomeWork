package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface MemberManagerInterface {
    void addMember(String familyName, String firstName, String fatherName, Person.Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath);
    Person findMember(String familyName, String firstName, String fatherName);
    List<Person> getSortedByName();
    List<Person> getSortedByDateOfBirth();
    void updateFamilyTree(FamilyTree<Person> familyTree);
}
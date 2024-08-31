package familytree.service;

import familytree.model.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeServiceInterface {
    void addMember(String familyName, String firstName, String fatherName, Person.Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath);
    Person findMember(String familyName, String firstName, String fatherName);
    void addParentChildRelationship(String parentFamilyName, String parentFirstName, String parentFatherName,
                                    String childFamilyName, String childFirstName, String childFatherName);
    List<Person> getSortedByName();
    List<Person> getSortedByDateOfBirth();
    void saveToFile(String filename) throws IOException;
    void loadFromFile(String filename) throws IOException, ClassNotFoundException;
}
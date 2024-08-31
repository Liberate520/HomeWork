package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;


import java.util.List;

public interface MemberManagerInterface {

    void addMember(Person person);
    Person findMember(String familyName, String firstName, String fatherName);
    List<Person> getSortedByName();
    List<Person> getSortedByDateOfBirth();
    void updateFamilyTree(FamilyTree<Person> familyTree);
}
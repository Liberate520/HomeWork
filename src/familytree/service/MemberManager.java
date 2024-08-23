package familytree.service;

import familytree.factory.PersonFactory;
import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.model.FullName;

import java.time.LocalDate;
import java.util.List;

public class MemberManager implements MemberManagerInterface{
    private FamilyTree<Person> familyTree;

    @Override
    public void updateFamilyTree(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void addMember(String familyName, String firstName, String fatherName, Person.Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        FullName fullName = new FullName(familyName, firstName, fatherName);
        Person newMember = new Person(fullName, gender, dateOfBirth, dateOfDeath);
        familyTree.addMember(newMember);
    }

    @Override
    public Person findMember(String familyName, String firstName, String fatherName) {
        return familyTree.findMemberByFullName(familyName, firstName, fatherName);
    }

    @Override
    public List<Person> getSortedByName() {
        if (familyTree == null) {
            throw new IllegalStateException("Семейное дерево не инициализировано. Пожалуйста, загрузите данные.");
        }
        return familyTree.getSortedByName();
    }

    @Override
    public List<Person> getSortedByDateOfBirth() {
        if (familyTree == null) {
            throw new IllegalStateException("Семейное дерево не инициализировано. Пожалуйста, загрузите данные.");
        }
        return familyTree.getSortedByDateOfBirth();
    }
}
package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.Person;


import java.util.List;

public class MemberManager implements MemberManagerInterface{
    private FamilyTree<Person> familyTree;

    @Override
    public void updateFamilyTree(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void addMember(Person person) {

        if (familyTree == null) {
            throw new IllegalStateException("Семейное дерево не инициализировано. Пожалуйста, загрузите данные.");
        }
        familyTree.addMember(person);
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
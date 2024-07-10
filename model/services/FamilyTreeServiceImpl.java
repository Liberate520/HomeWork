package model.services;

import model.FamilyTree;
import model.Person;

import java.util.Comparator;

public class FamilyTreeServiceImpl<T extends Person> implements FamilyTreeService<T> {
    private FamilyTree<T> familyTree;

    public FamilyTreeServiceImpl(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void addPerson(T person, Integer fatherId, Integer motherId) {
        if (fatherId != null) {
            Person father = familyTree.getMemberById(fatherId);
            if (father != null) {
                father.addChild(person);
            }
        }
        if (motherId != null) {
            Person mother = familyTree.getMemberById(motherId);
            if (mother != null) {
                mother.addChild(person);
            }
        }
        familyTree.addMember(person);
    }

    @Override
    public String showTree() {
        return familyTree.toString();
    }

    @Override
    public void sortByName() {
        familyTree.getMembers().sort(Comparator.comparing(Person::getName));
    }

    @Override
    public void sortByBirthDate() {
        familyTree.getMembers().sort(Comparator.comparing(Person::getBirthDate));
    }
}

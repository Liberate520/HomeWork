package ru.gb.family_tree.service;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;

import java.util.List;

public class FamilyTreeService {
    private FamilyTree familyTree;

    public FamilyTreeService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void addMember(Human human) {
        familyTree.addMember(human);
    }

    public List<Human> getMembers() {
        return familyTree.getMembers();
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByChildrenCount() {
        familyTree.sortByChildrenCount();
    }
}

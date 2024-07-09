package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.family_tree.TreeNode;

import java.util.List;

public class FamilyTreeService<E extends TreeNode<E>> {
    private final FamilyTree<E> familyTree;

    public FamilyTreeService(FamilyTree<E> familyTree) {
        this.familyTree = familyTree;
    }

    public boolean addHuman(E human) {
        return familyTree.addHuman(human);
    }

    public List<E> getSiblings(int id) {
        return familyTree.getSiblings(id);
    }

    public List<E> getByName(String name) {
        return familyTree.getByName(name);
    }

    public boolean setWedding(long humanId1, long humanId2) {
        return familyTree.setWedding(humanId1, humanId2);
    }

    public boolean setDivorce(long humanId1, long humanId2) {
        return familyTree.setDivorce(humanId1, humanId2);
    }

    public boolean removeHuman(long humanId) {
        return familyTree.remove(humanId);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public String getInfo() {
        return familyTree.getInfo();
    }
}

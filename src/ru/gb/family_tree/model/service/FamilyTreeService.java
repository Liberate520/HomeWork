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

    public E getById(long id) {
        return familyTree.getById(id);
    }

    public E getByName(String name) {
        for (E human : familyTree) {
            if (human.getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null; // Если человек с таким именем не найден
    }
}

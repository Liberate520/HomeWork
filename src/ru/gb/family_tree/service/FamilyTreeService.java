package ru.gb.family_tree.service;

import ru.gb.family_tree.family_tree.FamilyTree;

public class FamilyTreeService<T extends FamilyTreeItem<T>> {
    public String getInfo(FamilyTree<T> familyTree) {
        StringBuilder result = new StringBuilder();
        for (T human : familyTree) {
            result.append(human).append("\n");
        }
        return result.toString();
    }
}

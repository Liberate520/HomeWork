package ru.gb.familytree.service;

import ru.gb.familytree.family_tree.FamilyTree;
import ru.gb.familytree.human.Human;

public class FamilyTreeService {
    public String getInfo(FamilyTree familyTree) {
        StringBuilder result = new StringBuilder();
        for (Human human : familyTree) {
            result.append(human).append("\n");
        }
        return result.toString();
    }
}

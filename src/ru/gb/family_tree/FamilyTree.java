package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private final List<Human> familyTree;

    FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.familyTree.add(human);
    }

    public String findHuman(String name) {
        String result = "";
        for (int i = 0; i < this.familyTree.size(); i++) {
            if (this.familyTree.get(i).getName().equals(name)) {
                result += familyTree.get(i).toString();
            } else {
                result += String.format("Человек с именем %s не найден!", name);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Human human : this.familyTree) {
            result.append(human.toString());
            result.append("\n");
        }
        return result.toString();
    }
}

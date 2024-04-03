package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long currentLastId;

    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() { this(new ArrayList<>()); }

    public boolean add(Human human) {
        if (human == null) {
            return  false;
        }

        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(currentLastId++);

            addToParents(human);
            addToChildren(human);
            return true;
        }

    }

    @Override
    public String toString() {
        return "";
    }
}

package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> list;

    public FamilyTree() {
        list = new ArrayList<>();
    }

    public void add(Human human) {
        list.add(human);
    }

    @Override
    public String toString() {
        return "";
    }
}

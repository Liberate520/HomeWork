package ru.gb.familytree.FamilyTree;

import ru.gb.familytree.FamilyTree.Human.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> relatives;

    public FamilyTree() {
        relatives = new ArrayList<>();
    }

    public void setRelative(Human human) {
        this.relatives.add(human);
    }

    public List<Human> getParentsForHuman(Human human) {
        return relatives.get(relatives.indexOf(human)).getParents();
    }

    public List<Human> getChildrenForHuman(Human human) {
        return relatives.get(relatives.indexOf(human)).getChildren();
    }
}

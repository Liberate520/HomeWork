package ru.gb.familytree;

import java.util.List;

public class FamilyTree {
    private List<Human> relatives;

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

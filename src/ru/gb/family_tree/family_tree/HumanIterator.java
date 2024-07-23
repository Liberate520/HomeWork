package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int currentId;
    private List<Human> famTree;

    public HumanIterator(List<Human> famTree) {
        this.famTree = famTree;
    }

    @Override
    public boolean hasNext() {
        return currentId < famTree.size();
    }

    @Override
    public Human next() {
        return famTree.get(currentId++);
    }
}

package ru.gb.familytree.tree;

import ru.gb.familytree.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeFamilyIterator implements Iterator<Human> {

    private int index;
    private List<Human> humanList;

    public TreeFamilyIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index);
    }
}

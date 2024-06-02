package ru.gb.family_tree.tree;

import ru.gb.family_tree.humans.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int curId;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > curId;
    }

    @Override
    public Human next() {
        return humanList.get(curId++);
    }
}

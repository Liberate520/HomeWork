package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

class HumanIterator implements Iterator<Human> {
    private int curentId;
    private List<Human> humans;

    public HumanIterator(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > curentId;
    }

    @Override
    public Human next() {
        return humans.get(curentId++);
    }
}

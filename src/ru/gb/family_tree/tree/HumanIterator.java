package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

class HumanIterator<T> implements Iterator<T> {
    private int curentId;
    private List<T> humans;

    public HumanIterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > curentId;
    }

    @Override
    public T next() {
        return humans.get(curentId++);
    }
}

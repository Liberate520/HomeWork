package ru.gb.family_tree.human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T> implements Iterator<T> {
    private int curIndex;
    private List<T> humans;

    public HumanIterator(List<T> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > curIndex;
    }

    @Override
    public T next() {
        return humans.get(curIndex++);
    }
}

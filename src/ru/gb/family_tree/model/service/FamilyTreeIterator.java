package ru.gb.family_tree.model.service;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private int index;
    private final List<T> humans;

    public FamilyTreeIterator(List<T> humans) {
        this.humans = humans;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public T next() {
        return humans.get(index++);
    }
}

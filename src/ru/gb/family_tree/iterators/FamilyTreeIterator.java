package ru.gb.family_tree.iterators;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private List<T> members;
    private int currentIndex = 0;

    public FamilyTreeIterator(List<T> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < members.size();
    }

    @Override
    public T next() {
        return members.get(currentIndex++);
    }
}

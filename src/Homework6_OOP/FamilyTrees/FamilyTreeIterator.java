package Homework6_OOP.FamilyTrees;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private int index;
    private final List<T> entityList;

    public FamilyTreeIterator(List<T> entityList) {
        this.entityList = entityList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < entityList.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return entityList.get(index++);
    }
}

package com.oop.homeWorkOOP.lineAge;

import java.util.Iterator;
import java.util.List;

public class LineAgeIterator<T extends LineAgeItem> implements Iterator<T> {

    private List<T> tree;
    private int ind;

    public LineAgeIterator(List<T> tree) {
        this.tree = tree;
        ind = 0;
    }

    @Override
    public boolean hasNext() {
        return tree.size() > ind;
    }

    @Override
    public T next() {
        return tree.get(ind++);
    }

}

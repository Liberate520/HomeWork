package ru.gb.family_tree.model.tree;

import java.util.Iterator;
import java.util.List;

public class FTiterator<T> implements Iterator<T> {
    private int index;
    private List<T> tree;

    public FTiterator (List<T>tree){
        this.tree=tree;
    }

    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public T next() {
        return tree.get(index++);
    }
}

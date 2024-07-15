package ru.gb.familytree.tree;

import ru.gb.familytree.human.SomeBody;

import java.util.Iterator;
import java.util.List;

public class TreeFamilyIterator<T extends SomeBody> implements Iterator<T> {

    private int index;
    private List<T> humanList;

    public TreeFamilyIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public T next() {
        return humanList.get(index);
    }
}

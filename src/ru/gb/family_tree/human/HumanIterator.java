package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.TreeInterface;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends TreeInterface> implements Iterator<T> {
    private int currentId;
    private List<T> humanList;

    public HumanIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > currentId;
    }

    @Override
    public T next() {
        return (T) humanList.get(currentId++);
    }
}


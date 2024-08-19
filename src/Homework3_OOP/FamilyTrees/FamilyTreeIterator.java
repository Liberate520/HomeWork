package Homework3_OOP.FamilyTrees;

import Homework3_OOP.Human.Human;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private final List<Human> humanList;

    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return humanList.get(index++);
    }
}
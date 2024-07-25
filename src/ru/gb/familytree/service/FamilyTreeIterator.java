package ru.gb.familytree.service;

import ru.gb.familytree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int curIndex;
    private List<Human> humans;

    public FamilyTreeIterator(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > curIndex;
    }

    @Override
    public Human next() {
        return humans.get(curIndex++);
    }
}

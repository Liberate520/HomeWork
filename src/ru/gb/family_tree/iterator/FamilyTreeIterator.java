package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> humans;

    public FamilyTreeIterator(List<Human> humans) {
        this.humans = humans;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(index++);
    }
}
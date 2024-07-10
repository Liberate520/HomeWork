package ru.gb.oop.family_tree.human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    List<Human> humans;
    int current = 0;
    public HumanIterator(List<Human> humanList) {
            humans = humanList;
    }

    @Override
    public boolean hasNext() {
        return current < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(current++);
    }
}

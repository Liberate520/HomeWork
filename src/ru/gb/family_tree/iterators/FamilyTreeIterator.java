package ru.gb.family_tree.iterators;

import ru.gb.family_tree.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> members;
    private int currentIndex = 0;

    public FamilyTreeIterator(List<Human> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < members.size();
    }

    @Override
    public Human next() {
        return members.get(currentIndex++);
    }
}

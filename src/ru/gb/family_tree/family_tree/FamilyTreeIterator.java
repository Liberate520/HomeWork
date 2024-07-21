package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    public FamilyTreeIterator(List<Human> humanList) {
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Human next() {
        return null;
    }
}

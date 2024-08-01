package ru.gb2.family_tree7.model.family_tree;

import ru.gb2.family_tree7.model.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private final List<Human> members;
    private int position = 0;

    public FamilyTreeIterator(List<Human> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return position < members.size();
    }

    @Override
    public Human next() {
        return members.get(position++);
    }
}

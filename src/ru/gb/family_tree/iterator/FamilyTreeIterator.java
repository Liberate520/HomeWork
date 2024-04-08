package ru.gb.family_tree.iterator;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;


public class FamilyTreeIterator implements Iterator<Human> {
    private int idx;
    private List<Human> familyTreeList;

    public FamilyTreeIterator(List<Human> familyTreeList) {
        this.familyTreeList = familyTreeList;
    }

    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    @Override
    public Human next() {
        return familyTreeList.get(idx++);
    }
}


//------------------------------------------------------------------

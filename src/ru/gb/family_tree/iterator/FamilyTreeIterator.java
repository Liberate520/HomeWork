package ru.gb.family_tree.iterator;

import ru.gb.family_tree.family_tree.FamilyTreeElement;
import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;


public class FamilyTreeIterator<E extends FamilyTreeElement<E>> implements Iterator<E> {
    private int idx;
    private List<E> familyTreeList;

    public FamilyTreeIterator(List<E> familyTreeList) {
        this.familyTreeList = familyTreeList;
        idx = 0;
    }

    @Override
    public boolean hasNext() {
        return familyTreeList.size() > idx;
    }

    @Override
    public E next() {
        return familyTreeList.get(idx++);
    }
}


//------------------------------------------------------------------

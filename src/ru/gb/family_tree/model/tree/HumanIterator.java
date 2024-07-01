package ru.gb.family_tree.model.tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E extends FamTreeItem> implements Iterator<E> {
    private int curId;
    private List<E> familyTreeList;

    public HumanIterator(List<E> familyTreeList){
        this.familyTreeList = familyTreeList;
    }
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > curId;
    }

    @Override
    public E next() {
        return familyTreeList.get(curId++ );
    }
}
package ru.gb.family_tree.model.tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode<T>> implements Iterator<T> {

    private int curId;
    private List<T> humanList;

    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
        curId = 0;
    }

    @Override
    public boolean hasNext() {
//        return humanList.size() > curId;
        return curId < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(curId++);
    }
}

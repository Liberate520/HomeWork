package com.familytree.model.family_tree;

import com.familytree.model.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeNode> implements Iterator<T> {
    private List<Human> list;
    private int index;

    public FamilyTreeIterator(List<Human> list) {
        this.list = list;
        index = 0;
    }

    public boolean hasNext(){return index < list.size();}

    public T next(){return (T) list.get(index++);}
}

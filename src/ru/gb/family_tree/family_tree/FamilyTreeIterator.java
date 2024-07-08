package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.humen.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E> implements Iterator<E> {
    private  List<E> list;
    private  int index;

    public FamilyTreeIterator(List<E> humanList) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}

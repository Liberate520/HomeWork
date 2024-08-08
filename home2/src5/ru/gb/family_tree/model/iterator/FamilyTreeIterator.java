package ru.gb.family_tree.model.iterator;

import ru.gb.family_tree.model.family_tree.ElementFamilyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends ElementFamilyTree<E>> implements Iterator<E> {
    private int index;
    private List<E> itemList;

    public FamilyTreeIterator(List<E> itemList) {
        this.itemList = itemList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < itemList.size();
    }

    @Override
    public E next() {
        return itemList.get(index++);
    }
}


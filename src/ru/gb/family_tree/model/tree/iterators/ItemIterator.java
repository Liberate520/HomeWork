package ru.gb.family_tree.model.tree.iterators;

import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.model.item.FamilyTreeItem;

public class ItemIterator<E extends FamilyTreeItem<E>> implements Iterator<E> {
    private int index;
    private List<E> itemList;

    public ItemIterator(List<E> itemList2) {
        this.itemList = itemList2;
        index = 0;
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

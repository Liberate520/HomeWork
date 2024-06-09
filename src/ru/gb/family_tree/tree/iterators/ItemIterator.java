package ru.gb.family_tree.tree.iterators;

import java.util.Iterator;
import java.util.List;

import ru.gb.family_tree.item.FamilyTreeItem;

public class ItemIterator<E extends FamilyTreeItem<E>> implements Iterator<FamilyTreeItem<E>> {
    private int index;
    private List<FamilyTreeItem<E>> itemList;

    public ItemIterator(List<FamilyTreeItem<E>> itemList) {
        this.itemList = itemList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < itemList.size();
    }

    @Override
    public FamilyTreeItem<E> next() {
        return itemList.get(index++);
    }
}

package ru.gb.model.treeItem.comparators;

import ru.gb.model.node.TreeItem;

import java.util.Comparator;

public class ItemComparatorByName<E extends TreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

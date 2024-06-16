package ru.gb.family_tree.model.item.comparators;

import java.util.Comparator;

import ru.gb.family_tree.model.item.FamilyTreeItem;

public class ItemComparatorByName<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorById<T extends FamilyTreeItem<T>>
        implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

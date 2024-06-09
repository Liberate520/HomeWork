package ru.gb.family_tree.item.comparators;

import java.util.Comparator;

import ru.gb.family_tree.item.FamilyTreeItem;

public class ItemComparatorByAge<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
        // return o1.getAge() - o2.getAge(); // - тоже будет работать
    }
}

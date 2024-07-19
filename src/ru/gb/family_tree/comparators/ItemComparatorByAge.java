package ru.gb.family_tree.comparators;

import ru.gb.family_tree.family_tree.ElementFamilyTree;

import java.util.Comparator;

public class ItemComparatorByAge<E extends ElementFamilyTree<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

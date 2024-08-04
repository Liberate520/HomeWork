package ru.gb.family_tree.model.tree.comparators;

import ru.gb.family_tree.model.tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByAge<T extends ItemFamilyTree> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge()-o2.getAge();
    }
}

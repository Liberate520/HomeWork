package ru.gb.family_tree.model.service;

import java.util.Comparator;

public class HumanComparatorByBirthDay<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}

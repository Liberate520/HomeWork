package ru.gb.FamilyTree;

import ru.gb.FamilyTree.Human;

import java.util.Comparator;

public class FamilyTreeComparatorByName<T extends TreeMyTop<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

package ru.gb.family_tree.model.Human.comparator;

import ru.gb.family_tree.model.FT.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByBirthDate<T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

package ru.gb.family_tree;

import ru.gb.family_tree.FT.FamilyTreeItem;
import ru.gb.family_tree.Human.Human;

import java.util.Comparator;

public class ComparatorByBirthDate<T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

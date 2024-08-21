package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanCoparatorByBirthDate<T extends FamilyTreeItem>
        implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

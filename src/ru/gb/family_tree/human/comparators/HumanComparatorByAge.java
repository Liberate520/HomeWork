package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.family_tree.FamilyTreeItem;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}

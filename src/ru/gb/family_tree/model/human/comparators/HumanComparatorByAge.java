package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.family_tree.FamilyTreeItem;
import ru.gb.family_tree.model.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}

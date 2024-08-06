package ru.gb.family_tree.model.human.comparators;

import ru.gb.family_tree.model.familly_tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByBirthDate<T extends ItemFamilyTree> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

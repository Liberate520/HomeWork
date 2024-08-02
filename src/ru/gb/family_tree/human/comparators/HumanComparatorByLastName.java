package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.tree.ItemFamilyTree;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends ItemFamilyTree> implements Comparator<T> {


    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
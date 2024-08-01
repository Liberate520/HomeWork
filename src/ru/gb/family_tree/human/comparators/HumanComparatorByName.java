package ru.gb.family_tree.human.comparators;

import ru.gb.family_tree.family_tree.TreeInterface;
import ru.gb.family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeInterface> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.humen.Human;

import java.util.Comparator;
import java.util.TreeMap;

public class HumanComparatorByName<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

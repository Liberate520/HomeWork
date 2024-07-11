package ru.gb.family_tree.model.family_tree.comparators;

import ru.gb.family_tree.model.family_tree.TreeNode;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

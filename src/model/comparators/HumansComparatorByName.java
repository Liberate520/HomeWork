package model.comparators;

import model.family_tree.TreeNode;

import java.util.Comparator;

public class HumansComparatorByName<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

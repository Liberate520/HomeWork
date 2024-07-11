package model.human.comparators;

import model.family_tree.TreeNode;

import java.util.Comparator;

public class HumansComparatorById<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}

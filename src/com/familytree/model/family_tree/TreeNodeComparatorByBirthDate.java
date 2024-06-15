
package com.familytree.model.family_tree;

import java.util.Comparator;

public class TreeNodeComparatorByBirthDate<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}


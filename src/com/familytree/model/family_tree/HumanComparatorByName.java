package com.familytree.model.family_tree;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<TreeNode> {

    @Override
    public int compare(TreeNode o1, TreeNode o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

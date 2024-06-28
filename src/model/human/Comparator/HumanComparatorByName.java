package model.human.Comparator;

import java.util.Comparator;

import model.family_tree.TreeNode;

public class HumanComparatorByName<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public  int compare(T o1, T o2){ return o1.getName().compareTo(o2.getName()); }
}

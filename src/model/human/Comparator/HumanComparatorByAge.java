package model.human.Comparator;

import java.util.Comparator;

import model.family_tree.TreeNode;

public class HumanComparatorByAge<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public  int compare(T o1, T o2){ return o1.getAge() - o2.getAge();}
}

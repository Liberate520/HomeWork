package FamilyThreeOOP.Family.Comporator;

import FamilyThreeOOP.Family.TreeNode;

import java.util.Comparator;

public class FamilyTreeComporatorByAge<T extends TreeNode<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
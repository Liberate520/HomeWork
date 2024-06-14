package FamilyThreeOOP.Family.Comporator;

import FamilyThreeOOP.Family.TreeNode;

import java.util.Comparator;

public class FamilyTreeComporatorByName<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2){
        return o1.getName().compareTo(o2.getName());
    }
}

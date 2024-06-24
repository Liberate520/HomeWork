package model.family_tree.Comparator;
import java.util.Comparator;

import model.family_tree.TreeNode;

public class HumanComparatorByBirthDate<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public  int compare(T o1, T o2){

        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

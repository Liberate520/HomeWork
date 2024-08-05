package family_tree.model.family_tree.comparators;


import family_tree.model.family_tree.TreeNode;

import java.util.Comparator;


public class FamilyTreeComparatorByBirthDate<T extends TreeNode> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getDayOfBirth().compareTo(o2.getDayOfBirth());
    }
}

package family_TREE.model.family_tree;

import java.util.Comparator;

public class FamilyTreeComparatorByBirthDate<T extends TreeNode<T>> implements Comparator<T> {

    public int compare (T o1, T o2) {
        return o1.getBirthDate().compareTo(o2, o1.getBirthDate());
    }
}

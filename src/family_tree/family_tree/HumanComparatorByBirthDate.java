package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDate<T extends TreeNode<T>> implements Comparator<T> {

    public int compare(T o1, T o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

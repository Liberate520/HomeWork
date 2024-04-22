package family_tree.model.tree.sorting;

import family_tree.model.person.TreeNode;

import java.util.Comparator;

public class SortByDateOfBirth<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}

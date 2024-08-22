package family_tree.family_tree;

import com.sun.source.tree.Tree;
import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeNode<T>> implements Comparator<T> {

    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

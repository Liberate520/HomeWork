package family_tree.human;

import java.util.Comparator;

// import family_tree.family_tree.TreeNode;

// public class HumanComparatorByName<T extends TreeNode<T>> implements Comparator<T> {
//     @Override
//     public int compare(Human h1, Human h2) {
//         return h1.getName().compareTo(h2.getName());
//     }
// }

public class HumanComparatorByName<T> implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
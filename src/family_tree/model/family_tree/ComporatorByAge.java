package family_tree.model.family_tree;

import java.util.Comparator;

public class ComporatorByAge<T extends TreeNode<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }
}

package family_tree.family_tree;

import java.util.Comparator;
public class HumanComparatorByAge<T extends TreeNode<T>> implements Comparator<T>{
    public int compare(T o1, T o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

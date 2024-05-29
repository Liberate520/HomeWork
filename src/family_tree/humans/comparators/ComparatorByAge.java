package family_tree.humans.comparators;

import java.util.Comparator;
import family_tree.humans.Human;
import family_tree.tree.TreeItem;

public class ComparatorByAge<T extends TreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

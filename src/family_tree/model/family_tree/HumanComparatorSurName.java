package family_tree.model.family_tree;

import java.util.Comparator;

public class HumanComparatorSurName<T extends TreeRoot<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getSurName().compareTo(o2.getSurName());
    }
}
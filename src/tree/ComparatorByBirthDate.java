package tree;

import java.util.Comparator;

public class ComparatorByBirthDate<E extends TreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}

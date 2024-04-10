package family_tree.tree.sorting;

import family_tree.person.Human;

import java.util.Comparator;

public class SortByName<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

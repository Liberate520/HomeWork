package family_tree.tree.sorting;

import family_tree.person.BasicUnit;

import java.util.Comparator;

public class SortByAge<T extends BasicUnit> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if(o1.getAge() < o2.getAge()) return -1;
        if(o1.getAge() == o2.getAge()) return 0;
        return 1;
    }
}

package Family_Tree.Human;

import Family_Tree.FamilyTree.TreeVersatility;

import java.util.Comparator;

public class SortByAge<T extends TreeVersatility<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

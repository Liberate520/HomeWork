package Family_Tree.model.Human;

import Family_Tree.model.FamilyTree.TreeVersatility;

import java.util.Comparator;

public class SortByAge<T extends TreeVersatility<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

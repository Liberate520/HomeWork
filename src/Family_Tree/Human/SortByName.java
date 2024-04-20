package Family_Tree.Human;

import Family_Tree.FamilyTree.TreeVersatility;

import java.util.Comparator;

public class SortByName<T extends TreeVersatility<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

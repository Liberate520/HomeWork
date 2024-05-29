package family_tree_app.human.comparators;

import java.util.Comparator;

import family_tree_app.family_tree.FamilyTreeEntry;

public class ComparatorByName<T extends FamilyTreeEntry> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

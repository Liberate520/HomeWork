package family_tree.family_tree.comparators;

import family_tree.family_tree.ItemFamilyTree;

import java.util.Comparator;

public class ComparatorByFirstName<T extends ItemFamilyTree> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
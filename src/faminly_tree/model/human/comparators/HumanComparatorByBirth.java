package faminly_tree.model.human.comparators;

import faminly_tree.model.tree.FamiliItem;

import java.util.Comparator;

public class HumanComparatorByBirth<T extends FamiliItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirth().compareTo(o2.getBirth());
    }
}

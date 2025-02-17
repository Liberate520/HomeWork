package model.family_tree.instances.comparators;

import model.family_tree.tree.TreeItem;

import java.util.Comparator;

public class ComparatorByName<T extends TreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

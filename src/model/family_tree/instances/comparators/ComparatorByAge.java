package model.family_tree.instances.comparators;

import java.util.Comparator;

import model.family_tree.tree.TreeItem;

public class ComparatorByAge<T extends TreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

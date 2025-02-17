package model.family_tree.instances.comparators;

import model.family_tree.tree.TreeItem;

import java.util.Comparator;

public class ComparatorByDeathDate<T extends TreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDeathDate().compareTo(o2.getDeathDate());
    }
}

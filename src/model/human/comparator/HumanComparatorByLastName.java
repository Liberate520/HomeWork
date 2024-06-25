package model.human.comparator;

import model.tree.TreeItem;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends TreeItem>  implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
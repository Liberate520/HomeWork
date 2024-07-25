package model.compare_metods;

import model.familytree.TreeNodes;

import java.util.Comparator;

public class CompareByBirthDate<T extends TreeNodes<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}

package model.human.comparators;

import java.util.Comparator;

import model.family_tree.FamilyTreeItem;

public class HumanComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E h1, E h2) {
        return Integer.compare(h1.getAge(), h2.getAge());
    }

}